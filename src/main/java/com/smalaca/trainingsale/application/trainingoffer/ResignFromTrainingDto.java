package com.smalaca.trainingsale.application.trainingoffer;

import java.util.UUID;

public record ResignFromTrainingDto(UUID trainingId, String firstName, String lastName) {
}
