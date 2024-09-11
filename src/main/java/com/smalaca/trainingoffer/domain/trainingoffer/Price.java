package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal value;

    public Price(BigDecimal value) {
        this.value = value;
    }
}
