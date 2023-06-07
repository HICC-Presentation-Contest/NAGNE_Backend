package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class TripGetUseCase {

	private final TripQueryService tripQueryService;

	public TripResponse.TripInfoResponse getTrip(Long tripId){
		Trip trip = tripQueryService.findById(tripId);
		TripResponse.TripInfoResponse tripInfoResponse = TripMapper.mapToTripInfoResponse(trip);
		return tripInfoResponse;
	}

	public List<TripResponse.TripSimpleResponse> getTripList(Long userId){
		List<Trip> tripList = tripQueryService.findByUserId(userId);
		List<TripResponse.TripSimpleResponse> tripInfoResponseList = TripMapper.mapToTripInfoResponseList(tripList);
		return tripInfoResponseList;
	}
}
