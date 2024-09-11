package com.smalaca.trainingoffer.domain.trainingoffer;

import java.util.UUID;

public record CreateTrainingOfferCommand(
        UUID trainerId, UUID trainingProgramId, Period period, Price price, GroupSize groupSize, Location location) {
}
