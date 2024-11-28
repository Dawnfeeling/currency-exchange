package com.example.exchange.dto.exchange;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {

    @NotBlank(message = "currencyName은 필수 입력 항목입니다.")
    private String currencyName;

    @NotNull(message = "amount는 필수 입력 항목입니다.")
    @DecimalMin(value = "1000", message = "amount는 최소 1000 이상이어야 합니다.")
    private BigDecimal amount;
}
