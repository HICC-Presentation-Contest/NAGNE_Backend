package com.hicc.nagne_backend.domain.trip.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class TripResponse {

	public static class SimpleTripInfoResponse {
	}

	@Getter
	public static class TripInfoResponse {
		private long userId;
		private String username;

		private String address;
		private String title;

		private List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfo;

		@Builder
		public TripInfoResponse(long userId, String username, String address, String title, List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfo) {
			this.userId = userId;
			this.username = username;
			this.address = address;
			this.title = title;
			this.locationInfo = locationInfo;
		}
	}

	@Getter
	public static class TripSimpleResponse {
		private Long tripId;
		private String address;
		private String title;
		private Long tripCount;

		@Builder
		public TripSimpleResponse(Long tripId, String address, String title, Long tripCount) {
			this.tripId = tripId;
			this.address = address;
			this.title = title;
			this.tripCount = tripCount;
		}
	}
}
