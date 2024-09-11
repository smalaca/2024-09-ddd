package com.smalaca.trainingsale.application.trainingoffer;

import java.util.UUID;

public record BuyTrainingOfferDto(UUID trainingId, String firstName, String lastName, String paymentMethod) {
}
