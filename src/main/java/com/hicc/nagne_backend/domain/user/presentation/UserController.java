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

    @Operation(summary = "유저 기본 정보 반환", tags = {"UserController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 기본 정보 반환 성공"),
            @ApiResponse(responseCode = "404", description = "유저 기본 정보 반환 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping( "/user/signUp")
    public UserResponse.UserBasicResponse getBasicUserInfo(){
        return userGetUseCase.getBasicUserInfo();
    }

    @Operation(summary = "유저 추가 정보 등록", tags = {"UserController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유저 추가 정보 등록 성공"),
            @ApiResponse(responseCode = "404", description = "유저 추가 정보 등록 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping( "/user")
    public void updateUserInfo(@RequestBody UserRequest.UserCreateRequest userCreateRequest){
        userUpdateUseCase.updateUserInfo(userCreateRequest);
    }

    @Operation(summary = "유저 페이지 정보 조회", tags = {"UserController"})
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
    @PostMapping("/user/update")// 4개의 필드 모두 변경 가능
    public void updateUser(@RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateUseCase.updateUser(userUpdateRequest);
    }
}
