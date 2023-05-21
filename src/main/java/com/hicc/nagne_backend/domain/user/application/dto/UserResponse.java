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
        private int followerCount;
        private int followingCount;
        private List<TripResponse.UserPageTripInfoResponse> createTripList;
        private int createTripCount;

        @Builder
        public UserInfoResponse(String name, String description, int followerCount, int followingCount,
                                List<TripResponse.UserPageTripInfoResponse> createTripList, int createTripCount) {
            this.name = name;
            this.description = description;
            this.followerCount = followerCount;
            this.followingCount = followingCount;
            this.createTripList = createTripList;
            this.createTripCount = createTripCount;
        }
    }
}
