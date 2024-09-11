package com.smalaca.trainingsale.domain.reservation;

import com.smalaca.annotation.architecture.SecondaryPort;
import com.smalaca.annotation.ddd.DomainRepository;

import java.util.UUID;

@DomainRepository
@SecondaryPort
public interface ReservationRepository {
    void save(Reservation reservation);

    Reservation findById(UUID reservationId);

    void update(Reservation reservation);
}
