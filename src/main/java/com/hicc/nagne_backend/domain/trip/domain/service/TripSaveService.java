package com.hicc.nagne_backend.domain.trip.domain.service;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripSaveService {

    private final TripRepository tripRepository;

    public void save(String address, String title, User user) {
        Trip trip = Trip.builder()
                .address(address)
                .title(title)
                .user(user)
                .build();
        tripRepository.save(trip);
    }
}
