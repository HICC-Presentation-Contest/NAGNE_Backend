package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerQueryService {

    private final FollowRepository followRepository;

    public List<Follow> findFollowerListById(Long receiverId) {
        List<Follow> senderList = followRepository.findByReceiverId(receiverId);
        return senderList;

    }
}
