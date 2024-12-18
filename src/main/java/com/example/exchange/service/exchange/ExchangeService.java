package com.example.exchange.service.exchange;

import com.example.exchange.dto.exchange.ExchangeGroupResponseDto;
import com.example.exchange.dto.exchange.ExchangeResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ExchangeService {

    ExchangeResponseDto exchange(Long userId, String currencyName, BigDecimal amount);

    List<ExchangeResponseDto> findAllExchange(Long userId);

    ExchangeResponseDto cancelledExchange(Long id);

    ExchangeGroupResponseDto groupExchange(Long userId);
}
