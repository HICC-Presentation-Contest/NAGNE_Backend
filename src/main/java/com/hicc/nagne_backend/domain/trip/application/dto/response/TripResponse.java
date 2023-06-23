package com.hicc.nagne_backend.domain.trip.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class TripResponse {


	//여정통해서 여정정보 가져올때
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

	//마이페이지
	@Getter
	public static class TripSimpleResponse {
		private Long tripId;
		private String address;
		private String title;
		private LocalDateTime createdDate;
		private List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoList;

		@Builder
		public TripSimpleResponse(Long tripId, String address, String title, LocalDateTime createdDate, List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoList) {
			this.tripId = tripId;
			this.address = address;
			this.title = title;
			this.createdDate = createdDate;
			this.locationInfoList = locationInfoList;
		}
	}

	//첫화면, 검색

	/**
	 * 클래스명 변경 필요
	 */
	@Getter
	public static class TripSearchResponse {
		private Long tripId;
		private String address;
		private String title;
		private List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoList;

		@Builder
		public TripSearchResponse(Long tripId, String address, String title, List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoList, Long searchCount) {
			this.tripId = tripId;
			this.address = address;
			this.title = title;
			this.locationInfoList = locationInfoList;
		}
	}
}
