package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowingQueryService {

    private final FollowRepository followRepository;
    public List<Follow> findFollowingListById(Long senderId) {
        List<Follow> receiverList = followRepository.findBySenderId(senderId);
        return receiverList;

    }
    public Long countBySenderId(Long senderId) {
        Long count = followRepository.countBySenderId(senderId);
        return count;
    }
}