package com.smalaca.trainingsale.infrastructure.repository.trainingoffer;

import java.util.UUID;

class NotFoundTrainingOfferException extends RuntimeException {
    NotFoundTrainingOfferException(UUID id) {
    }
}
