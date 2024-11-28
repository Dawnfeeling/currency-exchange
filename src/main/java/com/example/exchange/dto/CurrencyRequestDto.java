package com.example.exchange.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {

    private String currencyName;

    private BigDecimal exchangeRate;

    private String symbol;

}
