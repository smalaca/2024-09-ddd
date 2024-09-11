package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public enum Location {
    REMOTE,
    ONSITE;

    public static Location of(String value) {
        try {
            return Location.valueOf(value);
        } catch (IllegalArgumentException exception) {
            throw new UnsupportedLocationException(value);
        }
    }
}
