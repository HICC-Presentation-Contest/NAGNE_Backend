package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowerQueryService;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowingQueryService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetUseCase;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.application.mapper.UserMapper;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UserGetUseCase {

    private final UserUtils userUtils;
    private final TripGetUseCase tripGetUseCase;

    private final FollowerQueryService followerQueryService;
    private final FollowingQueryService followingQueryService;
    private final TripQueryService tripQueryService;

    public UserResponse.UserInfoResponse getUser() {

        User user = userUtils.getUser();
        Long userId = user.getId();

        Long followerCount = followerQueryService.countByReceiverId(userId);
        Long followingCount = followingQueryService.countBySenderId(userId);

        List<TripResponse.TripSimpleResponse> createTripList = tripGetUseCase.getTripList(userId);

        Long createTripCount = tripQueryService.countByUserId(userId);

        //저장 기능 추가하면 저장한 여정도 가져와야함

        UserResponse.UserInfoResponse userInfoResponse =
                UserMapper.mapToUserInfoResponse(user, followerCount, followingCount, createTripList, createTripCount);

        return userInfoResponse;
    }
}
