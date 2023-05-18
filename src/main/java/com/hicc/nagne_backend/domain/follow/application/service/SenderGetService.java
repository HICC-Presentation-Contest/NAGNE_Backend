package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.domain.follow.application.dto.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.mapper.FollowMapper;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.service.SenderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SenderGetService {

    private final SenderQueryService senderQueryService;

    public List<FollowResponse.FollowInfoResponse> getSender(Long userId) {
        List<Follow> receiverIdList = senderQueryService.findById(userId);
        return FollowMapper.mapToFollowList(receiverIdList);

    }
}
