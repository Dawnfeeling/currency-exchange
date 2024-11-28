package com.example.exchange.service;

import com.example.exchange.dto.ExchangeResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ExchangeService {

    ExchangeResponseDto exchange(Long userId, String currencyName, BigDecimal amount);

    List<ExchangeResponseDto> findAllExchange(Long userId);

    ExchangeResponseDto cancelledExchange(Long id);
}
