package com.smalaca.trainingsale.domain.reservation;

class UnsupportedPaymentMethodException extends RuntimeException{
    private final String value;

    UnsupportedPaymentMethodException(String value) {
        this.value = value;
    }
}
