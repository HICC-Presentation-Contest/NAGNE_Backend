package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class FollowDeleteService {

    private final FollowRepository followRepository;

    public void deleteFollow(Long userId, Long receiverId){
        followRepository.deleteBySenderIdAndReceiverId(userId, receiverId);
    }
}
