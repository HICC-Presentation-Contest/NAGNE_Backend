package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.domain.follow.domain.service.FollowerQueryService;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowingQueryService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetService;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.application.mapper.UserMapper;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final TripGetService tripGetService;
    private final UserQueryService userQueryService;

    private final FollowerQueryService followerQueryService;
    private final FollowingQueryService followingQueryService;
    private final TripQueryService tripQueryService;

    public UserResponse.UserInfoResponse getUser(Long userId) {

        //userId로 User 가져오기
        User user = userQueryService.findById(userId);

        Long followerCount = followerQueryService.countByReceiverId(userId);
        Long followingCount = followingQueryService.countBySenderId(userId);

        List<TripResponse.TripSimpleResponse> createTripList = tripGetService.getTripList(userId);

        Long createTripCount = tripQueryService.countByUserId(userId);

        //저장 기능 추가하면 저장한 여정도 가져와야함

        UserResponse.UserInfoResponse userInfoResponse =
                UserMapper.mapToUserInfoResponse(user, followerCount, followingCount, createTripList, createTripCount);

        return userInfoResponse;
    }
}
