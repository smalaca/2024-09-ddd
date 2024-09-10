package com.smalaca.trainingsale.application.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryAdapter;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOffer;
import com.smalaca.trainingsale.domain.trainingoffer.TrainingOfferRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrainingOfferApplicationService {
    private final TrainingOfferRepository trainingOfferRepository;

    public TrainingOfferApplicationService(TrainingOfferRepository trainingOfferRepository) {
        this.trainingOfferRepository = trainingOfferRepository;
    }

    @PrimaryAdapter
    public void choose(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.choose();

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void buy(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.buy();

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void cancelReservation(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.cancelReservation();

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void resign(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.resign();

        trainingOfferRepository.update(trainingOffer);
    }

    @PrimaryAdapter
    public void start(UUID id) {
        TrainingOffer trainingOffer = trainingOfferRepository.findById(id);

        trainingOffer.start();

        trainingOfferRepository.update(trainingOffer);
    }
}
