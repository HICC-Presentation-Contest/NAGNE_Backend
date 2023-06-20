package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.mapper.FollowMapper;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowingQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FollowingGetUseCase {

    private final FollowingQueryService followingQueryService;

    public SliceResponse<FollowResponse.FollowInfoResponse> getFollowingList(Long userId, Pageable pageable) {
        Slice<Follow> receiverIdList = followingQueryService.findFollowingListById(userId, pageable);

        Slice<FollowResponse.FollowInfoResponse> followingResponseList
                = receiverIdList.map(follow -> {
                    return FollowMapper.mapToFollowingInfoResponse(follow);
                });

        return SliceResponse.of(followingResponseList);
    }
}
