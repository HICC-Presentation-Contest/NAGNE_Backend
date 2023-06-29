package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowerQueryService;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowingQueryService;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.application.mapper.UserMapper;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UserGetUseCase {

    private final UserUtils userUtils;
    private final FollowerQueryService followerQueryService;
    private final FollowingQueryService followingQueryService;
    private final UserQueryService userQueryService;

    public UserResponse.UserBasicResponse getBasicUserInfo() {
        User user = userUtils.getUser();
        return UserMapper.mapToUserBasicResponse(user);
    }

    public UserResponse.UserInfoResponse getUser(Long userId) {

        if(userId != null){
            User user = userQueryService.findById(userId);
            return getUserFollowResponse(userId, user);
        }

        User user = userUtils.getUser();
        Long findUserId = user.getId();
        return getUserFollowResponse(findUserId, user);
    }

    private UserResponse.UserInfoResponse getUserFollowResponse(Long userId, User user) {
        Long followerCount = followerQueryService.countByReceiverId(userId);
        Long followingCount = followingQueryService.countBySenderId(userId);

        UserResponse.UserInfoResponse userInfoResponse =
                UserMapper.mapToUserInfoResponse(user, followerCount, followingCount);

        return userInfoResponse;
    }
}
