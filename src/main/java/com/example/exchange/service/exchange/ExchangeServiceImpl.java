package com.example.exchange.service.exchange;

import com.example.exchange.dto.exchange.ExchangeResponseDto;
import com.example.exchange.entity.currency.Currency;
import com.example.exchange.entity.user.User;
import com.example.exchange.entity.exchange.UserCurrency;
import com.example.exchange.repository.currency.CurrencyRepository;
import com.example.exchange.repository.exchange.ExchangeRepository;
import com.example.exchange.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final ExchangeRepository exchangeRepository;

    //환전
    @Override
    public ExchangeResponseDto exchange(Long userId, String currencyName, BigDecimal amount) {

        User user = userRepository.findByIdOrElseThrow(userId);
        Currency currency = currencyRepository.findByCurrencyNameOrElseThrow(currencyName);

        //환율 계산(2자리수 반올림)
        BigDecimal amountAfterExchange = amount.divide(currency.getExchangeRate(), 2, RoundingMode.HALF_UP);

        UserCurrency userCurrency = new UserCurrency(amount, amountAfterExchange);
        userCurrency.setUser(user);
        userCurrency.setCurrency(currency);
        userCurrency.setStatus("normal");

        UserCurrency savedExchange = exchangeRepository.save(userCurrency);

        return new ExchangeResponseDto(
                savedExchange.getId(),
                savedExchange.getCurrency().getCurrencyName(),
                savedExchange.getAmountBeforeExchange(),
                savedExchange.getAmountAfterExchange(),
                savedExchange.getStatus()
        );
    }

    //특정 유저의 환전기록 조회
    @Override
    public List<ExchangeResponseDto> findAllExchange(Long userId) {
        return exchangeRepository.findAllByUserIdWithFetch(userId)
                .stream()
                .map(ExchangeResponseDto::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ExchangeResponseDto cancelledExchange(Long id) {

        UserCurrency userCurrency = exchangeRepository.findByIdOrElseThrow(id);
        userCurrency.setStatus("cancelled");

        return new ExchangeResponseDto(
                userCurrency.getId(),
                userCurrency.getCurrency().getCurrencyName(),
                userCurrency.getAmountBeforeExchange(),
                userCurrency.getAmountAfterExchange(),
                userCurrency.getStatus());
    }
}
