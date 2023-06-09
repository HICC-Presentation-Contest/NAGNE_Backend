package com.hicc.nagne_backend.domain.trip.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class TripSaveService {

    private final TripRepository tripRepository;

    public void save(Trip trip) {
        tripRepository.save(trip);
    }
}
