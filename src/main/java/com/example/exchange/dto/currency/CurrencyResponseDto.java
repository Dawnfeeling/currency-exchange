package com.example.exchange.dto.currency;

import com.example.exchange.entity.currency.Currency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyResponseDto {

    private final Long id;

    private final String currencyName;

    private final BigDecimal exchangeRate;

    private final String symbol;

    public CurrencyResponseDto(Long id, String currencyName, BigDecimal exchangeRate, String symbol) {
        this.id = id;
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }

    public static CurrencyResponseDto toDto(Currency currency) {
        return new CurrencyResponseDto(currency.getId(), currency.getCurrencyName(), currency.getExchangeRate(), currency.getSymbol());
    }
}
