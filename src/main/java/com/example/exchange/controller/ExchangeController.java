package com.example.exchange.controller;

import com.example.exchange.dto.ExchangeRequestDto;
import com.example.exchange.dto.ExchangeResponseDto;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users/{user_id}/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping
    public ResponseEntity<ExchangeResponseDto> exchange(
            @PathVariable("user_id") Long userId,
            @RequestBody ExchangeRequestDto dto) {

        ExchangeResponseDto exchangeResponseDto = exchangeService.exchange(userId, dto.getCurrencyName(), dto.getAmount());

        return new ResponseEntity<>(exchangeResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> findAllExchanges(@PathVariable("user_id") Long userId) {

        List<ExchangeResponseDto> exchangeResponseDtoList = exchangeService.findAllExchange(userId);

        return new ResponseEntity<>(exchangeResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ExchangeResponseDto> cancelledExchange(@PathVariable("id") Long id) {
        ExchangeResponseDto exchangeResponseDto = exchangeService.cancelledExchange(id);

        return new ResponseEntity<>(exchangeResponseDto, HttpStatus.OK);
    }
}
