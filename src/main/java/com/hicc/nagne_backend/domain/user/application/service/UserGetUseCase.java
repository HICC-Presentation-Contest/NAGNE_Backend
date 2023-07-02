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

import java.util.Objects;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UserGetUseCase {

    private final UserUtils userUtils;
    private final FollowerQueryService followerQueryService;
    private final FollowingQueryService followingQueryService;
    private final UserQueryService userQueryService;

    public UserResponse.UserBasicResponse getBasicUserInfo() {
        final User user = userUtils.getUser();
        return UserMapper.mapToUserBasicResponse(user);
    }

    public UserResponse.UserInfoResponse getUser(final Long userId) {
        if(Objects.nonNull(userId)){
            final User user = userQueryService.findById(userId);
            return getUserFollowResponse(user);
        }
        final User user = userUtils.getUser();
        return getUserFollowResponse(user);
    }

    private UserResponse.UserInfoResponse getUserFollowResponse(final User user) {
        final Long followerCount = followerQueryService.countByReceiverId(user.getId());
        final Long followingCount = followingQueryService.countBySenderId(user.getId());
        return UserMapper.mapToUserInfoResponse(user, followerCount, followingCount);
    }
}
