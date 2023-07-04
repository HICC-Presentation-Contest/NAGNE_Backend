package com.hicc.nagne_backend.domain.follow.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowDeleteService;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowQueryService;
import com.hicc.nagne_backend.domain.follow.domain.service.FollowSaveService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FollowCreateUseCase {

    private final UserQueryService userQueryService;
    private final UserUtils userUtils;
    private final FollowSaveService followSaveService;
    private final FollowQueryService followQueryService;
    private final FollowDeleteService followDeleteService;
    
    public void createFollow(Long receiverId){
        User user = userUtils.getUser();
        User receiver = userQueryService.findById(receiverId);

        if(followQueryService.existsByUserIdAndReceiverId(user.getId(), receiverId)){
            followDeleteService.deleteFollow(user.getId(), receiverId);
        } else{
            followSaveService.save(user, receiver);
        }
    }
}
