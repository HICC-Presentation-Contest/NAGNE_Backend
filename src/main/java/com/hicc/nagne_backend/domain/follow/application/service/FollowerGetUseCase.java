package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.mapper.FollowMapper;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowerQueryService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FollowerGetUseCase {

    private final FollowerQueryService followerQueryService;

    public List<FollowResponse.FollowInfoResponse> getFollowerList(Long userId) {
        List<Follow> receiverIdList = followerQueryService.findFollowerListById(userId);
        return FollowMapper.mapToFollowerList(receiverIdList);

    }
}
