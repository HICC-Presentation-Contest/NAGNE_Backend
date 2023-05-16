package com.hicc.nagne_backend.domain.trip.presentation;

import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripCreateService;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TripController {

	private final TripGetService tripGetService;
	private final TripCreateService tripCreateService;

	/**
	 * Page<SimpleTripInfoResponse> 반환
	 */
	@GetMapping("/trip")
	public void getSimpleTrip(){

	}

	/**
	 * TripInfoResponse
	 */
	@GetMapping("/trip/{tripId}")
	public TripResponse.TripInfoResponse getTrip(@PathVariable Long tripId){
		return tripGetService.getTrip(tripId);
	}

	@PostMapping("/trip")
	public void createTrip(@RequestBody TripRequest.TripCreateRequest tripCreateRequest){
		tripCreateService.createTrip(tripCreateRequest);
	}



}
