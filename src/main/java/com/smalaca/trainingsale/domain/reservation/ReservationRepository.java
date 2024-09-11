package com.smalaca.trainingsale.domain.reservation;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

@DomainRepository
@SecondaryPort
public interface ReservationRepository {
    void save(Reservation reservation);
}
