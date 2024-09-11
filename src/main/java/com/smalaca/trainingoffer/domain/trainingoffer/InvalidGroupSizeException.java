package com.smalaca.trainingoffer.domain.trainingoffer;

class InvalidGroupSizeException extends RuntimeException {
    private final int size;

    InvalidGroupSizeException(int size) {
        this.size = size;
    }
}
