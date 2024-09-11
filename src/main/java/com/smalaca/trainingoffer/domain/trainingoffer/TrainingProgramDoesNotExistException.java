package com.smalaca.trainingoffer.domain.trainingoffer;

import java.util.UUID;

class TrainingProgramDoesNotExistException extends RuntimeException {
    private final UUID trainingProgramId;

    TrainingProgramDoesNotExistException(UUID trainingProgramId) {
        this.trainingProgramId = trainingProgramId;
    }
}
