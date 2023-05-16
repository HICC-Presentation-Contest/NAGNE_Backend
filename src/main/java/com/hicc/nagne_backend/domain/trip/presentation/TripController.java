package com.hicc.nagne_backend.domain.trip.presentation;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TripController {

	private final TripGetService tripGetService;

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
	public void createTrip(){

	}

}
