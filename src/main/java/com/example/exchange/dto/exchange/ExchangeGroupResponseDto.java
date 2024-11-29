package com.example.exchange.dto.exchange;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeGroupResponseDto {

    private final Long count;

    private final BigDecimal totalAmount;

    public ExchangeGroupResponseDto(Long count, BigDecimal totalAmount) {
        this.count = count;
        this.totalAmount = totalAmount;
    }
}
