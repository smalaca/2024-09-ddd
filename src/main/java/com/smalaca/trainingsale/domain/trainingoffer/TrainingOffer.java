package com.smalaca.trainingsale.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;
import com.smalaca.annotation.ddd.Factory;
import com.smalaca.trainingsale.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingsale.domain.participant.Participant;
import com.smalaca.trainingsale.domain.price.Price;
import com.smalaca.trainingsale.domain.reservation.Reservation;
import com.smalaca.trainingsale.domain.trainingoffer.events.ResignedFromTrainingEvent;

import java.util.UUID;

@AggregateRoot
public class TrainingOffer {
    private final UUID trainingOfferId;
    private final Price price;
    private final TrainingGroup trainingGroup;
    private final ReservationList reservationList;
    private boolean isFinalized;

    TrainingOffer(UUID trainingOfferId, Price price, ReservationList reservationList, TrainingGroup trainingGroup) {
        this.trainingOfferId = trainingOfferId;
        this.price = price;
        this.reservationList = reservationList;
        this.trainingGroup = trainingGroup;
    }

    @PrimaryPort
    @Factory
    public Reservation choose(Participant participant) {
        if (isOfferClosed()) {
            throw new ClosedTrainingOfferException(trainingOfferId);
        }

        if (trainingGroup.hasAvailablePlaces()) {
            trainingGroup.book(participant);
        } else if (reservationList.hasAvailablePlaces()) {
            reservationList.add(participant);
        } else {
            throw new NoAvailablePlacesLeftException(trainingOfferId);
        }

        return new Reservation(trainingOfferId, price, participant);
    }

    @PrimaryPort
    public void confirmFor(Participant participant) {
        trainingGroup.confirm(participant);
    }

    @PrimaryPort
    public void cancelReservation(Participant participant) {
        trainingGroup.cancelBooking(participant);
    }

    @PrimaryPort
    public void resign(Participant participant, EventPublisher eventPublisher) {
        trainingGroup.resign(participant);

        ResignedFromTrainingEvent event = new ResignedFromTrainingEvent(trainingOfferId, participant.firstName(), participant.lastName());
        eventPublisher.publish(event);
    }

    @PrimaryPort
    public void start() {
        isFinalized = true;
    }

    private boolean isOfferClosed() {
        return false;
    }
}
