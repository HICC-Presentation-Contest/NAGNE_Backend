package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FollowCheckUseCase {

    private final FollowQueryService followQueryService;
    private final UserUtils userUtils;

    public boolean checkFollow(Long receiverId){
        Long senderId = userUtils.getUser().getId();
        return followQueryService.existsByUserIdAndReceiverId(senderId, receiverId);
    }
}
