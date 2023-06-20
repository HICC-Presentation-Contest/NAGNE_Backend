package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.mapper.FollowMapper;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowerQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FollowerGetUseCase {

    private final FollowerQueryService followerQueryService;

    public SliceResponse<FollowResponse.FollowInfoResponse> getFollowerList(Long userId, Pageable pageable) {
        Slice<Follow> senderIdList = followerQueryService.findFollowerListById(userId, pageable);

        Slice<FollowResponse.FollowInfoResponse> followerResponseList
                = senderIdList.map(follow -> {
                    return FollowMapper.mapToFollowerInfoResponse(follow);
                });

        return SliceResponse.of(followerResponseList);
    }
}
