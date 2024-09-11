package com.smalaca.trainingsale.domain.reservation;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public enum PaymentMethod {
    BLIK, PAYPAL;

    public static PaymentMethod of(String value) {
        try {
            return PaymentMethod.valueOf(value);
        } catch (IllegalArgumentException exception) {
            throw new UnsupportedPaymentMethodException(value);
        }
    }
}
