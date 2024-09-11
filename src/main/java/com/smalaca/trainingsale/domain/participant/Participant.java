package com.smalaca.trainingsale.domain.participant;

import com.smalaca.annotation.ddd.ValueObject;

@ValueObject
public class Participant {
    private final String firstName;
    private final String lastName;

    public Participant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean isSameAs(Participant participant) {
        return firstName.equals(participant.firstName) && lastName.equals(participant.lastName);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }
}
