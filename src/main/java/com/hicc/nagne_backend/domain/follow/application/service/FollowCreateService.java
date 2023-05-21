package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.domain.follow.application.dto.request.FollowRequest;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowSaveService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowCreateService {

    private final UserQueryService userQueryService;
    private final FollowSaveService followSaveService;
    
    public void createFollow(FollowRequest.FollowCreateRequest followRequest) {
        User sender = userQueryService.findById(followRequest.getUserId());
        User receiver = userQueryService.findById(followRequest.getReceiverId());
        followSaveService.save(sender, receiver);
    }
}
