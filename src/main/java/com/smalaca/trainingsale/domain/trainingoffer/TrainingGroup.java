package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.DomainEntity;

import java.util.ArrayList;
import java.util.List;

@DomainEntity
class TrainingGroup {
    private final int maxParticipantsNumber;
    private final List<Participant> participants = new ArrayList<>();
    private final List<Participant> bookings = new ArrayList<>();

    TrainingGroup(int maxParticipantsNumber) {
        this.maxParticipantsNumber = maxParticipantsNumber;
    }

    void add(Participant participant) {
        participants.add(participant);
    }

    void remove(Participant participant) {
        Participant existing = find(participant);
        participants.remove(existing);
    }

    private Participant find(Participant participant) {
        return participants.stream()
                .filter(existing -> existing.isSameAs(participant))
                .findFirst()
                .get();
    }

    boolean hasAvailablePlaces() {
        return (bookings.size() + participants.size()) < maxParticipantsNumber;
    }

    void book(Participant participant) {
        bookings.add(participant);
    }

    void cancelBooking(Participant participant) {
        bookings.remove(participant);
    }

    void confirm(Participant participant) {
        bookings.remove(participant);
        participants.add(participant);
    }

    void resign(Participant participant) {
        participants.remove(participant);
    }
}
