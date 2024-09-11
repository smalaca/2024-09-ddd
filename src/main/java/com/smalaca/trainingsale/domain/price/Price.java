package com.smalaca.trainingsale.domain.price;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }
}
