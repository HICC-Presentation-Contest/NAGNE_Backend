package com.hicc.nagne_backend.domain.follow.presentation;

import com.hicc.nagne_backend.common.exception.dto.ErrorResponse;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.follow.application.dto.response.FollowResponse;
import com.hicc.nagne_backend.domain.follow.application.service.FollowCreateUseCase;
import com.hicc.nagne_backend.domain.follow.application.service.FollowerGetUseCase;
import com.hicc.nagne_backend.domain.follow.application.service.FollowingGetUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowerGetUseCase followerGetUseCase;
    private final FollowingGetUseCase followingGetUseCase;
    private final FollowCreateUseCase followCreateUseCase;

    @Operation(summary = "팔로워 조회", tags = {"FollowController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "팔로워 조회 성공"),
            @ApiResponse(responseCode = "404", description = "팔로워 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/follow/follower/{userId}")
    public SliceResponse<FollowResponse.FollowInfoResponse> getFollowerList(@PathVariable Long userId, Pageable pageable){
        return followerGetUseCase.getFollowerList(userId, pageable);
    }

    @Operation(summary = "팔로잉 조회", tags = {"FollowController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "팔로잉 조회 성공"),
            @ApiResponse(responseCode = "404", description = "팔로잉 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/follow/following/{userId}")
    public SliceResponse<FollowResponse.FollowInfoResponse> getFollowingList(@PathVariable Long userId, Pageable pageable){
        return followingGetUseCase.getFollowingList(userId, pageable);
    }

    @Operation(summary = "팔로우 생성", tags = {"FollowController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "팔로우 생성 성공"),
            @ApiResponse(responseCode = "404", description = "팔로우 생성 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/follow")
    public void follow(@RequestParam Long receiverId){
        followCreateUseCase.createFollow(receiverId);
    }
}
