package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.follow.application.dto.request.FollowRequest;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowSaveService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FollowCreateUseCase {

    private final UserQueryService userQueryService;
    private final FollowSaveService followSaveService;
    
    public void createFollow(FollowRequest.FollowCreateRequest followRequest) {
        User sender = userQueryService.findById(followRequest.getSenderId());
        User receiver = userQueryService.findById(followRequest.getReceiverId());
        followSaveService.save(sender, receiver);
    }
}
