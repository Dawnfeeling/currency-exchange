package com.example.exchange.repository;

import com.example.exchange.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByCurrencyName(String currencyName);

    default Currency findByCurrencyNameOrElseThrow(String currencyName) {

        return findByCurrencyName(currencyName).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 통화가 없습니다."));
    }
}
