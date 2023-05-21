package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.domain.follow.domain.service.FollowerQueryService;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowingQueryService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetService;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import com.hicc.nagne_backend.domain.user.application.dto.UserResponse;
import com.hicc.nagne_backend.domain.user.application.mapper.UserMapper;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final TripQueryService tripQueryService;
    private final TripGetService tripGetService;

    private final FollowerQueryService followerQueryService;
    private final FollowingQueryService followingQueryService;
    public UserResponse.UserInfoResponse getUser(Long tripId) {

        User user = tripQueryService.findById(tripId).getUser();
        Long userId = user.getId();

        int followerCount = followerQueryService.findFollowerListById(userId).size();
        int followingSize = followingQueryService.findFollowingListById(userId).size();

        List<TripResponse.UserPageTripInfoResponse> createTripList = tripGetService.getTripList(userId);
        int createTripCount = createTripList.size();
        //저장 기능 추가하면 저장한 여정도 가져와야함

        UserResponse.UserInfoResponse userInfoResponse =
                UserMapper.mapToUserInfoResponse(user, followerCount, followingSize, createTripList, createTripCount);

        return userInfoResponse;
    }
}
