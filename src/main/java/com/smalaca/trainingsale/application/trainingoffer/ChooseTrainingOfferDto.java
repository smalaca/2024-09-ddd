package com.smalaca.trainingsale.application.trainingoffer;

import java.util.UUID;

public record ChooseTrainingOfferDto(UUID trainingId, String firstName, String lastName, String phoneNumber) {}
