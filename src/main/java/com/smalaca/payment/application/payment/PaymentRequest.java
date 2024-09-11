package com.smalaca.payment.application.payment;

import java.math.BigDecimal;

public record PaymentRequest(String from, String to, BigDecimal price, String reason) {
}
