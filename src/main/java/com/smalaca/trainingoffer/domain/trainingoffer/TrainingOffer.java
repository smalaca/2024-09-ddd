package com.smalaca.trainingoffer.domain.trainingoffer;

import com.smalaca.annotation.architecture.PrimaryPort;
import com.smalaca.annotation.ddd.AggregateRoot;

@AggregateRoot
public class TrainingOffer {
    @PrimaryPort
    public TrainingOffer() {}
}
