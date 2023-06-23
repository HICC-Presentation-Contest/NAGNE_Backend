package com.hicc.nagne_backend.domain.user.presentation;

import com.hicc.nagne_backend.common.exception.dto.ErrorResponse;
import com.hicc.nagne_backend.domain.user.application.dto.request.UserRequest;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.application.service.UserGetUseCase;
import com.hicc.nagne_backend.domain.user.application.service.UserUpdateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserGetUseCase userGetUseCase;
    private final UserUpdateUseCase userUpdateUseCase;

    @Operation(summary = "유저 정보 조회", tags = {"UserController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 정보 조회 성공"),
            @ApiResponse(responseCode = "404", description = "유저 정보 조회 실패",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping( "/user")
    public UserResponse.UserInfoResponse getUser(@RequestParam(required = false) Long userId){
        return userGetUseCase.getUser(userId);
    }

    @Operation(summary = "유저 정보 수정(사용 안함)", tags = {"UserController"})
    @PostMapping("/user")// 4개의 필드 모두 변경 가능
    public void updateUser(@RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateUseCase.updateUser(userUpdateRequest);
    }
}
