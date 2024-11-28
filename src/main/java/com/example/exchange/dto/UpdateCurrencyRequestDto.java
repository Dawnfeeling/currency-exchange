package com.example.exchange.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UpdateCurrencyRequestDto {

    private String currencyName;

    private BigDecimal exchangeRate;
}
