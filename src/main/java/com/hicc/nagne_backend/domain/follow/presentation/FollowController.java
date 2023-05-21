package com.hicc.nagne_backend.domain.follow.presentation;

import com.hicc.nagne_backend.domain.follow.application.dto.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.service.FollowerGetService;
import com.hicc.nagne_backend.domain.follow.application.service.FollowingGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowerGetService followerGetService;
    private final FollowingGetService followingGetService;

    @GetMapping("/follower/{userId}")
    public List<FollowResponse.FollowInfoResponse> getFollowerList(@PathVariable Long userId){
        return followerGetService.getFollowerList(userId);
    }

    @GetMapping("/following/{userId}")
    public List<FollowResponse.FollowInfoResponse> getFollowingList(@PathVariable Long userId){
        return followingGetService.getFollowingList(userId);
    }

}
