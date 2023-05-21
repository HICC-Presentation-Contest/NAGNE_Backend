package com.hicc.nagne_backend.domain.user.application.dto;

import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class UserResponse {

    @Getter
    public static class UserInfoResponse {

        private String name;
        private String description;
        private Long followerCount;
        private Long followingCount;
        private List<TripResponse.TripSimpleResponse> createTripList;
        private Long createTripCount;

        @Builder
        public UserInfoResponse(String name, String description, Long followerCount, Long followingCount,
                                List<TripResponse.TripSimpleResponse> createTripList, Long createTripCount) {
            this.name = name;
            this.description = description;
            this.followerCount = followerCount;
            this.followingCount = followingCount;
            this.createTripList = createTripList;
            this.createTripCount = createTripCount;
        }
    }
}
