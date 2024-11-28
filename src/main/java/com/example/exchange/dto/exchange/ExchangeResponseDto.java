package com.example.exchange.dto.exchange;

import com.example.exchange.entity.exchange.UserCurrency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeResponseDto {

    private final Long id;

    private final String currencyName;

    private final BigDecimal amountBeforeExchange;

    private final BigDecimal amountAfterExchange;

    private final String status;

    public ExchangeResponseDto(Long id, String currencyName, BigDecimal amountBeforeExchange, BigDecimal amountAfterExchange, String status) {
        this.id = id;
        this.currencyName = currencyName;
        this.amountBeforeExchange = amountBeforeExchange;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public static ExchangeResponseDto toDto(UserCurrency userCurrency) {
        return new ExchangeResponseDto(
                userCurrency.getId(),
                userCurrency.getCurrency().getCurrencyName(),
                userCurrency.getAmountBeforeExchange(),
                userCurrency.getAmountAfterExchange(),
                userCurrency.getStatus());
    }
}
