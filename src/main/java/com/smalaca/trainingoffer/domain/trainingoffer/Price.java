package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.Factory;
import com.smalaca.annotation.ddd.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Price {
    private final BigDecimal value;

    public Price(BigDecimal value) {
        this.value = value;
    }

    @Factory
    public static Price of(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            return new Price(price);
        }

        throw new PriceException(price);
    }
}
