package com.example.exchange.service.currency;

import com.example.exchange.dto.currency.CurrencyResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyService {

    CurrencyResponseDto createCurrency(String currencyName, BigDecimal exchangeRate, String symbol);

    List<CurrencyResponseDto> findAllCurrencies();

    CurrencyResponseDto updateCurrency(String currencyName, BigDecimal exchangeRate);
}
