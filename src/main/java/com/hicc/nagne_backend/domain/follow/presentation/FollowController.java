package com.hicc.nagne_backend.domain.follow.presentation;

import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.follow.application.dto.request.FollowRequest;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.service.FollowCreateUseCase;
import com.hicc.nagne_backend.domain.follow.application.service.FollowerGetUseCase;
import com.hicc.nagne_backend.domain.follow.application.service.FollowingGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowerGetUseCase followerGetUseCase;
    private final FollowingGetUseCase followingGetUseCase;
    private final FollowCreateUseCase followCreateUseCase;

    @GetMapping("/follower/{userId}")
    public SliceResponse<FollowResponse.FollowInfoResponse> getFollowerList(@PathVariable Long userId, Pageable pageable){
        return followerGetUseCase.getFollowerList(userId, pageable);
    }

    @GetMapping("/following/{userId}")
    public SliceResponse<FollowResponse.FollowInfoResponse> getFollowingList(@PathVariable Long userId, Pageable pageable){
        return followingGetUseCase.getFollowingList(userId, pageable);
    }

    @PostMapping("/follow")
    public void follow(@RequestBody FollowRequest.FollowCreateRequest followRequest){
        followCreateUseCase.createFollow(followRequest);
    }
}
