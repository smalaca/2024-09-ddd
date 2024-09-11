package com.smalaca.trainingsale.domain.payment;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentDto(String paymentMethod, UUID trainingOfferId, String firstName, String lastName, BigDecimal price) {
}
