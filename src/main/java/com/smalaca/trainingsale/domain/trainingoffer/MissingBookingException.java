package com.smalaca.trainingsale.domain.trainingoffer;

class MissingBookingException extends RuntimeException {
    private final Participant participant;

    MissingBookingException(Participant participant) {
        this.participant = participant;
    }
}
