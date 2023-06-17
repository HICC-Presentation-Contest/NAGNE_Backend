package com.hicc.nagne_backend.domain.follow.presentation;

import com.hicc.nagne_backend.domain.follow.application.dto.request.FollowRequest;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.service.FollowCreateUseCase;
import com.hicc.nagne_backend.domain.follow.application.service.FollowerGetUseCase;
import com.hicc.nagne_backend.domain.follow.application.service.FollowingGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowerGetUseCase followerGetUseCase;
    private final FollowingGetUseCase followingGetUseCase;
    private final FollowCreateUseCase followCreateUseCase;

    @GetMapping("/follower/{userId}")
    public List<FollowResponse.FollowInfoResponse> getFollowerList(@PathVariable Long userId){
        return followerGetUseCase.getFollowerList(userId);
    }

    @GetMapping("/following/{userId}")
    public List<FollowResponse.FollowInfoResponse> getFollowingList(@PathVariable Long userId){
        return followingGetUseCase.getFollowingList(userId);
    }

    @PostMapping("/follow")
    public void follow(@RequestBody FollowRequest.FollowCreateRequest followRequest){
        followCreateUseCase.createFollow(followRequest);
    }
}
