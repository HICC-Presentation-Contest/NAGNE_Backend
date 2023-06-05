package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.mapper.FollowMapper;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowingQueryService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FollowingGetUseCase {

    private final FollowingQueryService followingQueryService;

    public List<FollowResponse.FollowInfoResponse> getFollowingList(Long userId) {
        List<Follow> receiverIdList = followingQueryService.findFollowingListById(userId);
        return FollowMapper.mapToFollowingList(receiverIdList);
    }
}