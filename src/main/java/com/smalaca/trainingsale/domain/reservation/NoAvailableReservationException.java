package com.smalaca.trainingsale.domain.reservation;

import java.util.UUID;

class NoAvailableReservationException extends RuntimeException {
    private final UUID trainingOfferId;

    NoAvailableReservationException(UUID trainingOfferId) {
        this.trainingOfferId = trainingOfferId;
    }
}
