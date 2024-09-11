package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Participant {
    private final String firstName;
    private final String lastName;

    public Participant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    boolean isSameAs(Participant participant) {
        return firstName.equals(participant.firstName) && lastName.equals(participant.lastName);
    }

    String firstName() {
        return firstName;
    }

    String lastName() {
        return lastName;
    }
}
