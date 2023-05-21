package com.hicc.nagne_backend.domain.follow.presentation;

import com.hicc.nagne_backend.domain.follow.application.dto.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.service.FollowerGetService;
import com.hicc.nagne_backend.domain.follow.application.service.FollwingGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowerGetService followerGetService;
    private final FollwingGetService followingGetService;

    @GetMapping("/followSender/{userId}")
    public List<FollowResponse.FollowInfoResponse> getSender(@PathVariable Long userId){
        return followerGetService.getSender(userId);
    }

    @GetMapping("/followReceiver/{userId}")
    public List<FollowResponse.FollowInfoResponse> getReceiver(@PathVariable Long userId){
        return followingGetService.getReceiver(userId);
    }

}
