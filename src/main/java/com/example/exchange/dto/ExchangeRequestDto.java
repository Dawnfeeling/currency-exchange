package com.example.exchange.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {

    private String currencyName;

    private BigDecimal amount;
}
