package com.example.exchange.controller;

import com.example.exchange.dto.CurrencyRequestDto;
import com.example.exchange.dto.CurrencyResponseDto;
import com.example.exchange.dto.UpdateCurrencyRequestDto;
import com.example.exchange.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<CurrencyResponseDto> createCurrency(@RequestBody CurrencyRequestDto dto) {

        CurrencyResponseDto currencyResponseDto = currencyService.createCurrency(
                dto.getCurrencyName(),
                dto.getExchangeRate(),
                dto.getSymbol()
        );

        return new ResponseEntity<>(currencyResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponseDto>> findAllCurrencies() {

        List<CurrencyResponseDto> currencyResponseDtoList = currencyService.findAllCurrencies();

        return new ResponseEntity<>(currencyResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<CurrencyResponseDto> updateCurrency(@RequestBody UpdateCurrencyRequestDto dto) {

        CurrencyResponseDto currencyResponseDto = currencyService.updateCurrency(dto.getCurrencyName(), dto.getExchangeRate());

        return new ResponseEntity<>(currencyResponseDto, HttpStatus.OK);
    }
}
