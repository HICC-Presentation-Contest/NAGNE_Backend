package com.hicc.nagne_backend.domain.trip.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
