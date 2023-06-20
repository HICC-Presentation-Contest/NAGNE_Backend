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
public class FollowerQueryService {

    private final FollowRepository followRepository;

    public Slice<Follow> findFollowerListById(Long receiverId, Pageable pageable) {
        Slice<Follow> senderList = followRepository.findByReceiverId(receiverId, pageable);
        return senderList;

    }
    public Long countByReceiverId(Long receiverId) {
        Long count = followRepository.countByReceiverId(receiverId);
        return count;
    }
}
