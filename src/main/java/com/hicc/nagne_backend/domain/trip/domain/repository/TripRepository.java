package com.hicc.nagne_backend.domain.trip.domain.repository;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByUserId(Long userId);

}
