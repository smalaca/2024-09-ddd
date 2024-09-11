package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.trainingsale.domain.participant.Participant;

class MissingBookingException extends RuntimeException {
    private final Participant participant;

    MissingBookingException(Participant participant) {
        this.participant = participant;
    }
}
