package com.hicc.nagne_backend.domain.trip.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class TripResponse {


	//여정통해서 여정정보 가져올때
	@Getter
	public static class TripInfoResponse {
		@Schema(description = "사용자 식별자", defaultValue = "userId")
		private long userId;
		@Schema(description = "사용자 이름", defaultValue = "userName")
		private String username;
		@Schema(description = "주소", defaultValue = "address")
		private String address;
		@Schema(description = "제목", defaultValue = "title")
		private String title;
		@Schema(description = "여행 장소 리스트", defaultValue = "locationInfoList")
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
		@Schema(description = "여행 식별자", defaultValue = "tripId")
		private Long tripId;
		@Schema(description = "주소", defaultValue = "address")
		private String address;
		@Schema(description = "제목", defaultValue = "title")
		private String title;
		@Schema(description = "생성 날짜", defaultValue = "createdDate")
		private LocalDateTime createdDate;
		@Schema(description = "여행 장소 리스트", defaultValue = "locationInfoList")
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
	@Getter
	public static class TripSearchResponse {
		@Schema(description = "여행 식별자", defaultValue = "tripId")
		private Long tripId;
		@Schema(description = "주소", defaultValue = "address")
		private String address;
		@Schema(description = "제목", defaultValue = "title")
		private String title;
		@Schema(description = "여행 장소 리스트", defaultValue = "locationInfoList")
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
