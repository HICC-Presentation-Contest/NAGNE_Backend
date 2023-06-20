package com.hicc.nagne_backend.domain.trip.presentation;

import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripCountGetUseCase;
import com.hicc.nagne_backend.domain.trip.application.service.TripCreateUseCase;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TripController {

	private final TripGetUseCase tripGetUseCase;
	private final TripCreateUseCase tripCreateUseCase;
	private final TripCountGetUseCase tripCountGetUseCase;

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
	public void createTrip(@ModelAttribute TripRequest.TripCreateRequest tripCreateRequest) {
		tripCreateUseCase.createTrip(tripCreateRequest);
	}

	@GetMapping("/trip/user/{userId}")
	public SliceResponse<TripResponse.TripSimpleResponse> getTripListByUserId(@PathVariable Long userId, Pageable pageable){
		return tripGetUseCase.getTripListByUserId(userId, pageable);
	}

	@GetMapping("/trip/user/{userId}/count")
	public Long getTripCount(@PathVariable Long userId) {
		return tripCountGetUseCase.getTripCount(userId);
	}

}
