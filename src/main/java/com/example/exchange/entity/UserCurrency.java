package com.example.exchange.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "user_currency")
public class UserCurrency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    //환전 전 금액
    private BigDecimal amountBeforeExchange;

    //환전 후 금액
    private BigDecimal amountAfterExchange;

    @Setter
    private String status;

    public UserCurrency() {}

    public UserCurrency(BigDecimal amountBeforeExchange, BigDecimal amountAfterExchange) {
        this.amountBeforeExchange = amountBeforeExchange;
        this.amountAfterExchange = amountAfterExchange;
    }

}
