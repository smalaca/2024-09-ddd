package com.smalaca.trainingsale.domain.trainingoffer;

import java.util.UUID;

class ClosedTrainingOfferException extends RuntimeException {
    private final UUID trainingOfferId;

    ClosedTrainingOfferException(UUID trainingOfferId) {
        this.trainingOfferId = trainingOfferId;
    }
}
