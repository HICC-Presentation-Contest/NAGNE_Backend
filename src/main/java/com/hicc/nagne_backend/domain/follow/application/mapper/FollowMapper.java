package com.hicc.nagne_backend.domain.follow.application.mapper;

import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FollowMapper {
    public static FollowResponse.FollowInfoResponse mapToFollowerInfoResponse(Follow follow) {
        return FollowResponse.FollowInfoResponse.builder()
                .userId(follow.getSender().getId())
                .name(follow.getSender().getName())
                .profileImage(follow.getSender().getProfileUrl())
                .build();
    }

    public static FollowResponse.FollowInfoResponse mapToFollowingInfoResponse(Follow follow) {
        return FollowResponse.FollowInfoResponse.builder()
                .userId(follow.getReceiver().getId())
                .name(follow.getReceiver().getName())
                .profileImage(follow.getReceiver().getProfileUrl())
                .build();
    }
}
