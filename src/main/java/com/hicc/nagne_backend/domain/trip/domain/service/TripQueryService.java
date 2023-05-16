package com.hicc.nagne_backend.domain.trip.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripQueryService {

	private final TripRepository tripRepository;

	public Trip findById(Long tripId){
		Trip trip = tripRepository.findById(tripId)
			.orElseThrow(() -> new IllegalArgumentException("해당 여정이 존재하지 않습니다."));
		return trip;
	}
}
