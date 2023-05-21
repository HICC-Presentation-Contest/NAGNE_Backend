package com.hicc.nagne_backend.domain.trip.application.mapper;

import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TripMapper {

	public static TripResponse.TripInfoResponse mapToTripInfoResponse(Trip trip) {
		return TripResponse.TripInfoResponse.builder()
				.userId(trip.getUser().getId())
				.username(trip.getUser().getName())
				.address(trip.getAddress())
				.title(trip.getTitle())
				.build();
	}

	public static List<TripResponse.UserPageTripInfoResponse> mapToTripInfoResponseList(List<Trip> tripList) {
		return tripList.stream()
				.map(trip -> TripResponse.UserPageTripInfoResponse.builder()
						.address(trip.getAddress())
						.title(trip.getTitle())
						.build())
				.collect(Collectors.toList());
	}

}
