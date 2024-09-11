package com.smalaca.trainingsale.application.trainingoffer;

import java.util.UUID;

public record CancelReservationDto(UUID trainingId, String firstName, String lastName) {
}
