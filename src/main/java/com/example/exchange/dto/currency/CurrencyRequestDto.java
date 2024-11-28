package com.example.exchange.dto.currency;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {

    @NotBlank(message = "currencyName은 필수 입력 항목입니다.")
    private String currencyName;

    @NotNull(message = "exchangeRate는 필수 입력 항목입니다.")
    private BigDecimal exchangeRate;

    private String symbol;

}
