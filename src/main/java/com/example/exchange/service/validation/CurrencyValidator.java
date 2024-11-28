package com.example.exchange.service.validation;

import com.example.exchange.entity.currency.Currency;
import com.example.exchange.repository.currency.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyValidator {

    private final CurrencyRepository currencyRepository;

    @PostConstruct
    public void validateCurrency() {
        log.info("환율 검사 시작");

        List<Currency> currencyList = currencyRepository.findAll();
        log.info("조회된 환율 개수: {}", currencyList.size());

        for(Currency currency : currencyList) {
            if(isInvalidExchangeRate(currency.getExchangeRate())){
                log.warn("유효하지 않은 환율 : 코드={}, 환율={}", currency.getCurrencyName(), currency.getExchangeRate());
            }
        }

        log.info("환율 검사 종료");
    }

    private boolean isInvalidExchangeRate(BigDecimal exchangeRate) {
        return exchangeRate == null || exchangeRate.compareTo(BigDecimal.ZERO) <= 0;
    }
}
