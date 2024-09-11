package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.annotation.ddd.Factory;

@DomainEntity
public class Participant {
    private final ParticipantName participantName;
    private final PhoneNumber phoneNumber;

    private Participant(ParticipantName participantName, PhoneNumber phoneNumber) {
        this.participantName = participantName;
        this.phoneNumber = phoneNumber;
    }

    @Factory
    public static Participant of(String firstName, String lastName, String phoneNumber) {
        return new Participant(new ParticipantName(firstName, lastName), new PhoneNumber(phoneNumber));
    }

    boolean hasName(ParticipantName participantName) {
        return this.participantName.sameAs(participantName);
    }
}
