package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
class PhoneNumber {
    private final String value;

    PhoneNumber(String value) {
        this.value = value;
    }
}
