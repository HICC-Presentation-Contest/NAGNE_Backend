package com.hicc.nagne_backend.domain.trip.presentation;

import com.hicc.nagne_backend.common.exception.dto.ErrorResponse;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripCountGetUseCase;
import com.hicc.nagne_backend.domain.trip.application.service.TripCreateUseCase;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
	public Slice<TripResponse.TripSearchResponse> getMainPageTrip(@RequestParam String address, Pageable pageable){
		return tripGetUseCase.getMainPageTrip(address, pageable);
	}

	/**
	 * TripInfoResponse
	 */
	@Operation(summary = "여행 상세 정보 조회", tags = {"TripController"})
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "여행 상세 정보 조회 성공"),
			@ApiResponse(responseCode = "404", description = "여행 상세 정보 조회 실패",
			content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	@GetMapping("/trip/{tripId}")
	public TripResponse.TripInfoResponse getTrip(
			@Parameter(description = "여정 id", in = ParameterIn.PATH) @PathVariable Long tripId){
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

	@GetMapping("/trip/search/address")
	public Slice<TripResponse.TripSearchResponse> getTripListByAddress(@RequestParam String address, Pageable pageable){
		return tripGetUseCase.getTripListByAddress(address, pageable);
	}

	@GetMapping("/trip/search/address/count")
	public Long getTripCountByAddress(@RequestParam String address) {
		return tripCountGetUseCase.getTripCountByAddress(address);
	}

	@GetMapping("trip/search/tag")
	public Slice getTripListByTag(@RequestParam String tagName, Pageable pageable){
		return tripGetUseCase.getTripListByTag(tagName, pageable);
	}

	@GetMapping("/trip/search/tag/count")
	public Long getTripCountByTag(@RequestParam String tagName) {
		return tripCountGetUseCase.getTripCountByTag(tagName);
	}
}
