package com.example.exchange.service;

import com.example.exchange.dto.CurrencyResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface CurrencyService {

    CurrencyResponseDto createCurrency(String currencyName, BigDecimal exchangeRate, String symbol);

    List<CurrencyResponseDto> findAllCurrencies();

    CurrencyResponseDto updateCurrency(String currencyName, BigDecimal exchangeRate);
}
