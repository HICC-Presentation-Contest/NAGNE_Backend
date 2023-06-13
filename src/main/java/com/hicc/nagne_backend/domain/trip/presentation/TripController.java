package com.hicc.nagne_backend.domain.trip.presentation;

import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripCreateUseCase;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TripController {

	private final TripGetUseCase tripGetUseCase;
	private final TripCreateUseCase tripCreateUseCase;

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
		return tripGetUseCase.getTrip(tripId);
	}

	@PostMapping("/trip")
	public void createTrip(@RequestBody TripRequest.TripCreateRequest tripCreateRequest) throws IOException {
		tripCreateUseCase.createTrip(tripCreateRequest);
	}



}
