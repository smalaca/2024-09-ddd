package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.trainingsale.domain.participant.Participant;

import java.util.ArrayList;
import java.util.List;

@DomainEntity
class ReservationList {
    private final int maxReservationsNumber;
    private final List<Participant> participants = new ArrayList<>();

    ReservationList(int maxReservationsNumber) {
        this.maxReservationsNumber = maxReservationsNumber;
    }

    void add(Participant participant) {
        participants.add(participant);
    }

    boolean hasAvailablePlaces() {
        return participants.size() < maxReservationsNumber;
    }
}
