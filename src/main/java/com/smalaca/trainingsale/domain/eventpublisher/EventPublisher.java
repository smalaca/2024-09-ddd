package com.smalaca.trainingsale.domain.eventpublisher;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.trainingsale.domain.reservation.events.TrainingOfferPaidEvent;
import com.smalaca.trainingsale.domain.trainingoffer.events.ResignedFromTrainingEvent;

@SecondaryPort
public interface EventPublisher {
    void publish(ResignedFromTrainingEvent event);

    void publish(TrainingOfferPaidEvent event);
}
