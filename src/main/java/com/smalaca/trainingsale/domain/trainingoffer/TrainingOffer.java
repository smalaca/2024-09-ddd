package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

@AggregateRoot
public class TrainingOffer {
    private final List<Participant> reservations = new ArrayList<>();
    private final List<Participant> participants = new ArrayList<>();
    private boolean isFinalized;

    @PrimaryPort
    public void choose(Participant participant) {
        reservations.add(participant);
    }

    @PrimaryPort
    public void buy(ParticipantName participantName, PaymentMethod paymentMethod) {
        Participant participant = findReservation(participantName);

        reservations.remove(participant);
        participants.add(participant);
    }

    @PrimaryPort
    public void cancelReservation(ParticipantName participantName) {
        Participant participant = findReservation(participantName);
        reservations.remove(participant);
    }

    private Participant findReservation(ParticipantName participantName) {
        return reservations.stream()
                .filter(participant -> participant.hasName(participantName))
                .findFirst()
                .get();
    }

    @PrimaryPort
    public void resign() {

    }

    @PrimaryPort
    public void start() {
        isFinalized = true;
    }
}
