package com.smalaca.trainingsale.infrastructure.rest.trainingoffer;

import com.smalaca.trainingsale.application.trainingoffer.ChooseTrainingOfferDto;
import com.smalaca.trainingsale.application.trainingoffer.TrainingOfferApplicationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/training-sale/training-offer")
public class TrainingOfferRestController {
    private final TrainingOfferApplicationService trainingOfferApplicationService;

    TrainingOfferRestController(TrainingOfferApplicationService trainingOfferApplicationService) {
        this.trainingOfferApplicationService = trainingOfferApplicationService;
    }

    @PutMapping("choose")
    private void choose(ChooseTrainingOfferDto dto) {
        trainingOfferApplicationService.choose(dto);
    }

    @PutMapping("buy/{id}")
    private void buy(@PathVariable UUID id) {
        trainingOfferApplicationService.buy(id);
    }

    @PutMapping("cancel-reservation/{id}")
    private void cancelReservation(@PathVariable UUID id) {
        trainingOfferApplicationService.cancelReservation(id);
    }

    @PutMapping("resign/{id}")
    private void resign(@PathVariable UUID id) {
        trainingOfferApplicationService.resign(id);
    }

    @PutMapping("start/{id}")
    private void start(@PathVariable UUID id) {
        trainingOfferApplicationService.start(id);
    }
}
