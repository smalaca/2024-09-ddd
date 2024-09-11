package com.smalaca.trainingsale.domain.trainingoffer;

import java.util.UUID;

class NoAvailablePlacesLeftException extends RuntimeException {
    private final UUID trainingOfferId;

    NoAvailablePlacesLeftException(UUID trainingOfferId) {
        this.trainingOfferId = trainingOfferId;
    }
}
