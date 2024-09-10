package com.smalaca.trainingoffer.infrastructure.rest.trainingoffer;

import com.smalaca.trainingoffer.application.trainingoffer.TrainingOfferApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/training-offer")
public class TrainingOfferRestController {
    private final TrainingOfferApplicationService trainingOfferApplicationService;

    TrainingOfferRestController(TrainingOfferApplicationService trainingOfferApplicationService) {
        this.trainingOfferApplicationService = trainingOfferApplicationService;
    }

    @PostMapping
    public UUID create() {
        return trainingOfferApplicationService.create();
    }
}
