package com.hicc.nagne_backend.domain.user.presentation;

import com.hicc.nagne_backend.domain.user.application.dto.request.UserRequest;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.application.service.UserGetUseCase;
import com.hicc.nagne_backend.domain.user.application.service.UserUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserGetUseCase userGetUseCase;
    private final UserUpdateUseCase userUpdateUseCase;

    @GetMapping(value = {"/user/{userId}", "/user"})
    public UserResponse.UserInfoResponse getUser(@PathVariable(required = false) String userId){
        return userGetUseCase.getUser();
    }

    @PostMapping("/user")// 4개의 필드 모두 변경 가능
    public void updateUser(@RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateUseCase.updateUser(userUpdateRequest);
    }
}
