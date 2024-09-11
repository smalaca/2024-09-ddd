package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class ParticipantName {
    private final String firstName;
    private final String lastName;

    public ParticipantName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    boolean sameAs(ParticipantName participantName) {
        return firstName.equals(participantName.firstName) && lastName.equals(participantName.lastName);
    }
}
