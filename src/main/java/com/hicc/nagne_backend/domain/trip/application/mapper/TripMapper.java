package com.hicc.nagne_backend.domain.trip.application.mapper;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TripMapper {

	public static TripResponse.TripInfoResponse mapToTripInfoResponse(Trip trip, List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfoDetailsResponseList, boolean bookMark) {
		return TripResponse.TripInfoResponse.builder()
				.userId(trip.getUser().getId())
				.username(trip.getUser().getName())
				.address(trip.getAddress())
				.title(trip.getTitle())
				.locationInfo(locationInfoDetailsResponseList)
				.bookmark(bookMark)
				.build();
	}

	public static TripResponse.TripSimpleResponse mapToTripSimpleResponse(Trip trip, List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoUserResponseList) {
		return TripResponse.TripSimpleResponse.builder()
				.address(trip.getAddress())
				.title(trip.getTitle())
				.tripId(trip.getId())
				.createdDate(trip.getCreatedDate())
				.locationInfoList(locationInfoUserResponseList)
				.build();
	}

	public static Trip mapToTrip(TripRequest.TripCreateRequest tripCreateRequest, User user) {
		return Trip.builder()
				.address(tripCreateRequest.getAddress())
				.title(tripCreateRequest.getTitle())
				.user(user)
				.build();
	}

	public static TripResponse.TripSearchResponse mapToTripSearchResponse(Trip trip, List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoUserResponseList) {
		return TripResponse.TripSearchResponse.builder()
				.tripId(trip.getId())
				.address(trip.getAddress())
				.title(trip.getTitle())
				.locationInfoList(locationInfoUserResponseList)
				.build();
	}

	public static TripResponse.TripMainPageResponse mapToTripMainPageResponse(Trip trip, List<LocationInfoResponse.LocationInfoMainPageResponse> locationInfoMainPageResponseList) {
		return TripResponse.TripMainPageResponse.builder()
				.tripId(trip.getId())
				.address(trip.getAddress())
				.title(trip.getTitle())
				.locationInfoList(locationInfoMainPageResponseList)
				.build();
	}

}
