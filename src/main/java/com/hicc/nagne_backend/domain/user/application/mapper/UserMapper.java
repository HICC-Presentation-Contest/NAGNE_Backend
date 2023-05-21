package com.hicc.nagne_backend.domain.user.application.mapper;

import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.user.application.dto.UserResponse;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserResponse.UserInfoResponse mapToUserInfoResponse(User user, int followerCount, int followingCount,
                                                                      List<TripResponse.UserPageTripInfoResponse> createTripList,
                                                                      int createTripCount) {
        return UserResponse.UserInfoResponse.builder()
                .name(user.getName())
                .description(user.getDescription())
                .followerCount(followerCount)
                .followingCount(followingCount)
                .createTripList(createTripList)
                .createTripCount(createTripCount)
                .build();
    }
}
