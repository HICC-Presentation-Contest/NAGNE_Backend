package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.service.TripGetService;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;
import com.hicc.nagne_backend.domain.user.application.dto.UserResponse;
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

    private final FollowRepository followRepository;
    private final TripRepository tripRepository;
    public UserResponse.UserInfoResponse getUser(Long userId) {

        //userId로 User 가져오기
        User user = userQueryService.findById(userId);

        Long followerCount = followRepository.countByReceiverId(userId);
        Long followingCount = followRepository.countBySenderId(userId);

        List<TripResponse.TripSimpleResponse> createTripList = tripGetService.getTripList(userId);

        Long createTripCount = tripRepository.countByUserId(userId);

        //저장 기능 추가하면 저장한 여정도 가져와야함

        UserResponse.UserInfoResponse userInfoResponse =
                UserMapper.mapToUserInfoResponse(user, followerCount, followingCount, createTripList, createTripCount);

        return userInfoResponse;
    }
}
