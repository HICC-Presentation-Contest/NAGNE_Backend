package com.hicc.nagne_backend.domain.trip.domain.service;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripQueryService {

	private final TripRepository tripRepository;
	private final UserQueryService userQueryService;

	public Trip findById(Long tripId){
		Trip trip = tripRepository.findById(tripId)
			.orElseThrow(() -> new IllegalArgumentException("해당 여정이 존재하지 않습니다."));
		return trip;
	}

	public List<Trip> findByUserId(Long userId){
		List<Trip> tripList = tripRepository.findByUserId(userId);
		return tripList;
	}

}
