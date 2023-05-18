package com.hicc.nagne_backend.domain.follow.application.mapper;

import com.hicc.nagne_backend.domain.follow.application.dto.FollowResponse;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FollowMapper {
    public static List<FollowResponse.FollowInfoResponse> mapToFollowList(List<Follow> followList) {
        return followList.stream()
                .map(follow -> FollowResponse.FollowInfoResponse.builder()
                        .userId(follow.getSender().getId())
                        .build())
                .collect(Collectors.toList());
    }
}
