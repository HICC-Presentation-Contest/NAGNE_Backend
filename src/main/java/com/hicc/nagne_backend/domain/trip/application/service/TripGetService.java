package com.hicc.nagne_backend.domain.trip.application.service;

import org.springframework.stereotype.Service;

import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripGetService {

	private final TripQueryService tripQueryService;

	public TripResponse.TripInfoResponse getTrip(Long tripId){
		Trip trip = tripQueryService.findById(tripId);
		TripResponse.TripInfoResponse tripInfoResponse = TripMapper.mapToTripInfoResponse(trip);
		return tripInfoResponse;
	}
}
