package com.hicc.nagne_backend.domain.follow.domain.service;

import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import com.hicc.nagne_backend.domain.follow.domain.repository.FollowRepository;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowSaveService {

    private final FollowRepository followRepository;

    public void save(User sender, User receiver) {
        Follow follow = Follow.builder()
                .sender(sender)
                .receiver(receiver)
                .build();
        followRepository.save(follow);
    }
}
