package com.smalaca.trainingsale.application.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.trainingsale.domain.eventpublisher.EventPublisher;
import com.smalaca.trainingsale.domain.payment.PaymentService;
import com.smalaca.trainingsale.domain.trainingoffer.Participant;
import com.smalaca.trainingsale.domain.trainingoffer.PaymentMethod;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOffer;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOfferRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrainingOfferApplicationService {
    private final TrainingOfferRepository trainingOfferRepository;
    private final EventPublisher eventPublisher;
    private final PaymentService paymentService;

    public TrainingOfferApplicationService(
            TrainingOfferRepository trainingOfferRepository, EventPublisher eventPublisher, PaymentService paymentService) {
        this.trainingOfferRepository = trainingOfferRepository;
        this.eventPublisher = eventPublisher;
        this.paymentService = paymentService;
    }

    @PrimaryAdapter
    public void choose(ChooseTrainingOfferDto dto) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(dto.trainingId());
        Participant participant = new Participant(dto.firstName(), dto.lastName());

        trainingOffer.choose(participant);

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void buy(BuyTrainingOfferDto dto) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(dto.trainingId());
        Participant participant = new Participant(dto.firstName(), dto.lastName());
        PaymentMethod paymentMethod = PaymentMethod.of(dto.paymentMethod());

        trainingOffer.buy(participant, paymentMethod, paymentService);

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
