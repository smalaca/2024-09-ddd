package com.smalaca.trainingoffer.domain.trainingoffer;

import java.util.UUID;

class TrainerDoesNotExistException extends RuntimeException {
    private final UUID trainerId;

    TrainerDoesNotExistException(UUID trainerId) {
        this.trainerId = trainerId;
    }
}
