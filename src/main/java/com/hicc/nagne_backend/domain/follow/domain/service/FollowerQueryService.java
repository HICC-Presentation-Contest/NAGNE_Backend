package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class FollowerQueryService {

    private final FollowRepository followRepository;

    public List<Follow> findFollowerListById(Long receiverId) {
        List<Follow> senderList = followRepository.findByReceiverId(receiverId);
        return senderList;

    }
    public Long countByReceiverId(Long receiverId) {
        Long count = followRepository.countByReceiverId(receiverId);
        return count;
    }
}
