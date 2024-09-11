package com.smalaca.trainingsale.application.trainingoffer;

import com.smalaca.trainingsale.domain.trainingoffer.Participant;

import java.util.UUID;

public record ChooseTrainingOfferDto(UUID trainingId, String firstName, String lastName, String phoneNumber) {
    Participant participant() {
        return Participant.of(firstName, lastName, phoneNumber);
    }
}
