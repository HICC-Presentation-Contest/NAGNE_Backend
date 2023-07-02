package com.hicc.nagne_backend.domain.trip.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class TripResponse {

	//첫화면
	@Getter
	public static class TripMainPageResponse {
		@Schema(description = "여행 식별자", defaultValue = "tripId")
		private Long tripId;
		@Schema(description = "주소", defaultValue = "address")
		private String address;
		@Schema(description = "제목", defaultValue = "title")
		private String title;
		@Schema(description = "여정 지도 이미지", defaultValue = "tripImageUrl")
		private String tripImageUrl;

		@Builder
		public TripMainPageResponse(Long tripId, String address, String title,
									String tripImageUrl) {
			this.tripId = tripId;
			this.address = address;
			this.title = title;
			this.tripImageUrl = tripImageUrl;
		}
	}

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
		@Schema(description = "북마크 여부", defaultValue = "false")
		private boolean bookmark;

		@Builder
		public TripInfoResponse(long userId, String username, String address, String title,
								List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfo, boolean bookmark) {
			this.userId = userId;
			this.username = username;
			this.address = address;
			this.title = title;
			this.locationInfo = locationInfo;
			this.bookmark = bookmark;
		}
	}

	//마이페이지
	@Getter
	public static class TripUserSimpleResponse {
		@Schema(description = "여행 식별자", defaultValue = "tripId")
		private Long tripId;
		@Schema(description = "주소", defaultValue = "address")
		private String address;
		@Schema(description = "제목", defaultValue = "title")
		private String title;
		@Schema(description = "생성 날짜", defaultValue = "createdDate")
		private LocalDate createdDate;
		@Schema(description = "여행 장소 리스트", defaultValue = "locationInfoList")
		private List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoList;

		@Builder
		public TripUserSimpleResponse(Long tripId, String address, String title, LocalDate createdDate, List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoList) {
			this.tripId = tripId;
			this.address = address;
			this.title = title;
			this.createdDate = createdDate;
			this.locationInfoList = locationInfoList;
		}
	}

	//검색
	@Getter
	public static class TripSearchResponse {
		@Schema(description = "여행 식별자", defaultValue = "tripId")
		private Long tripId;
		@Schema(description = "주소", defaultValue = "address")
		private String address;
		@Schema(description = "제목", defaultValue = "title")
		private String title;
		@Schema(description = "여정 지도 이미지", defaultValue = "tripImageUrl")
		private String tripImageUrl;

		@Builder
		public TripSearchResponse(Long tripId, String address, String title, String tripImageUrl) {
			this.tripId = tripId;
			this.address = address;
			this.title = title;
			this.tripImageUrl = tripImageUrl;
		}
	}

	public static class TripCountResponse{
		@Schema(description = "여행 수", defaultValue = "count")
		private Long count;

		@Builder
		public TripCountResponse(Long count) {
			this.count = count;
		}
	}

	@Getter
	public static class TripUserResponse{
		private Long tripId;
		private String tripImageUrl;
		private boolean bookmark;

		@Builder
		public TripUserResponse(Long tripId, String tripImageUrl, boolean bookmark) {
			this.tripId = tripId;
			this.tripImageUrl = tripImageUrl;
			this.bookmark = bookmark;
		}
	}
}
