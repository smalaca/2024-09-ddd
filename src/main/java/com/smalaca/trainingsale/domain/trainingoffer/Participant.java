package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.ddd.DomainEntity;
import com.smalaca.annotation.ddd.Factory;

@DomainEntity
public class Participant {
    private final String firstName;
    private final String lastName;
    private final PhoneNumber phoneNumber;

    private Participant(String firstName, String lastName, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Factory
    public static Participant of(String firstName, String lastName, String phoneNumber) {
        return new Participant(firstName, lastName, new PhoneNumber(phoneNumber));
    }
}
