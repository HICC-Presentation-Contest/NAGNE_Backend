package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class FollowingQueryService {

    private final FollowRepository followRepository;
    public Slice<Follow> findFollowingListById(Long senderId, Pageable pageable) {
        Slice<Follow> receiverList = followRepository.findBySenderId(senderId, pageable);
        return receiverList;

    }
    public Long countBySenderId(Long senderId) {
        Long count = followRepository.countBySenderId(senderId);
        return count;
    }
}