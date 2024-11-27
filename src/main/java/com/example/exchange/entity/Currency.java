package com.example.exchange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currencyName;

    private BigDecimal exchangeRate;

    private String status;

    @OneToMany(mappedBy = "currency")
    private List<UserCurrency> userCurrencies = new ArrayList<>();

    public Currency() {}

    public Currency(String currencyName, BigDecimal exchangeRate, String status) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.status = status;
    }
}
