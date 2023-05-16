package com.hicc.nagne_backend.domain.trip.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class TripResponse {

	public static class SimpleTripInfoResponse {

	}

	@Getter
	public static class TripInfoResponse {
		private long userId;
		private String username;

		private String address;
		private String title;

		@Builder
		public TripInfoResponse(long userId, String username, String address, String title) {
			this.userId = userId;
			this.username = username;
			this.address = address;
			this.title = title;
		}
	}
}
