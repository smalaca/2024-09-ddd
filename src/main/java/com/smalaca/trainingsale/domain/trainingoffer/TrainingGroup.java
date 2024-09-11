package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.DomainEntity;

import java.util.ArrayList;
import java.util.List;

@DomainEntity
class TrainingGroup {
    private final List<Participant> participants = new ArrayList<>();

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
}
