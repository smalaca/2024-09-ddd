package com.smalaca.trainingoffer.domain.eventpublished;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.trainingoffer.domain.trainingoffer.events.TrainingOfferPublishedEvent;

@SecondaryPort
public interface EventPublisher {
    void publish(TrainingOfferPublishedEvent event);
}
