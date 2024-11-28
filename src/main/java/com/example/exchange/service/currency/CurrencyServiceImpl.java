package com.example.exchange.service.currency;

import com.example.exchange.dto.currency.CurrencyResponseDto;
import com.example.exchange.entity.currency.Currency;
import com.example.exchange.repository.currency.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    public CurrencyResponseDto createCurrency(String currencyName, BigDecimal exchangeRate, String symbol) {

        Currency currency = new Currency(currencyName, exchangeRate, symbol);
        Currency savedCurrency = currencyRepository.save(currency);

        return new CurrencyResponseDto(savedCurrency.getId(), savedCurrency.getCurrencyName(), savedCurrency.getExchangeRate(), savedCurrency.getSymbol());
    }

    //현재 환전 가능한 통화 조회
    @Override
    public List<CurrencyResponseDto> findAllCurrencies() {

        return currencyRepository.findAll()
                .stream()
                .map(CurrencyResponseDto::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CurrencyResponseDto updateCurrency(String currencyName, BigDecimal exchangeRate) {

        Currency currency = currencyRepository.findByCurrencyNameOrElseThrow(currencyName);

        currency.updateExchangeRate(exchangeRate);

        return new CurrencyResponseDto(currency.getId(), currency.getCurrencyName(), currency.getExchangeRate(), currency.getSymbol());
    }
}
