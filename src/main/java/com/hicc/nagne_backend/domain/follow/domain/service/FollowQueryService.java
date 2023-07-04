package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class FollowQueryService {

    private final FollowRepository followRepository;

    public boolean existsByUserIdAndReceiverId(Long userId, Long receiverId){
        return followRepository.existsBySenderIdAndReceiverId(userId, receiverId);
    }
}
