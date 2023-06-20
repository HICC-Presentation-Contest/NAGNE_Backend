package com.hicc.nagne_backend.domain.trip.domain.repository;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

    Slice<Trip> findByUserId(Long userId, Pageable pageable);

    Long countByUserId(Long userId);

}
