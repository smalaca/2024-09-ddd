package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
class Price {
    private final BigDecimal value;

    Price(BigDecimal value) {
        this.value = value;
    }

    BigDecimal value() {
        return value;
    }
}
