package com.smalaca.payment.infrastructure.api;

import static com.smalaca.payment.infrastructure.api.PaymentStatus.ERROR;
import static com.smalaca.payment.infrastructure.api.PaymentStatus.FAILURE;
import static com.smalaca.payment.infrastructure.api.PaymentStatus.SUCCESS;

public record PaymentResponse(PaymentStatus status, String message) {
    static PaymentResponse success() {
        return new PaymentResponse(SUCCESS, null);
    }

    static PaymentResponse failure(String message) {
        return new PaymentResponse(FAILURE, message);
    }

    static PaymentResponse error(String message) {
        return new PaymentResponse(ERROR, message);
    }
}
