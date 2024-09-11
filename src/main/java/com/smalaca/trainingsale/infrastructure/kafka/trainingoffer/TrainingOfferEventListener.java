package com.smalaca.trainingsale.infrastructure.kafka.trainingoffer;

import com.smalaca.trainingsale.application.trainingoffer.TrainingOfferApplicationService;
import com.smalaca.trainingsale.domain.reservation.events.TrainingOfferPaidEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TrainingOfferEventListener {
    private final TrainingOfferApplicationService trainingOfferApplicationService;

    TrainingOfferEventListener(TrainingOfferApplicationService trainingOfferApplicationService) {
        this.trainingOfferApplicationService = trainingOfferApplicationService;
    }

    @EventListener
    public void consume(TrainingOfferPaidEvent event) {
        trainingOfferApplicationService.confirmPayment(event);
    }
}
