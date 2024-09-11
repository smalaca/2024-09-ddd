package com.smalaca.trainingsale.application.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.trainingsale.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingsale.domain.participant.Participant;
import com.smalaca.trainingsale.domain.reservation.Reservation;
import com.smalaca.trainingsale.domain.reservation.ReservationRepository;
import com.smalaca.trainingsale.domain.reservation.events.TrainingOfferPaidEvent;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOffer;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOfferRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrainingOfferApplicationService {
    private final TrainingOfferRepository trainingOfferRepository;
    private final ReservationRepository reservationRepository;
    private final EventPublisher eventPublisher;

    public TrainingOfferApplicationService(
            TrainingOfferRepository trainingOfferRepository, ReservationRepository reservationRepository, EventPublisher eventPublisher) {
        this.trainingOfferRepository = trainingOfferRepository;
        this.reservationRepository = reservationRepository;
        this.eventPublisher = eventPublisher;
    }

    @PrimaryAdapter
    public void choose(ChooseTrainingOfferDto dto) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(dto.trainingId());
        Participant participant = new Participant(dto.firstName(), dto.lastName());

        Reservation reservation = trainingOffer.choose(participant);

        reservationRepository.save(reservation);
        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void confirmPayment(TrainingOfferPaidEvent event) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(event.trainingOfferId());
        Participant participant = new Participant(event.firstName(), event.lastName());

        trainingOffer.confirmFor(participant);

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void cancelReservation(CancelReservationDto dto) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(dto.trainingId());
        Participant participant = new Participant(dto.firstName(), dto.lastName());

        trainingOffer.cancelReservation(participant);

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void resign(ResignFromTrainingDto dto) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(dto.trainingId());
        Participant participant = new Participant(dto.firstName(), dto.lastName());

        trainingOffer.resign(participant, eventPublisher);

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void start(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.start();

        trainingOfferRepository.update(trainingOffer);
    }
}
