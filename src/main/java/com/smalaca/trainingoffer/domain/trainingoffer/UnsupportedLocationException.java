package com.smalaca.trainingoffer.domain.trainingoffer;

class UnsupportedLocationException extends RuntimeException {
    private final String location;

    UnsupportedLocationException(String location) {
        this.location = location;
    }
}
