package com.hicc.nagne_backend.domain.user.presentation;

import com.hicc.nagne_backend.domain.user.application.dto.request.UserRequest;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.application.service.UserGetService;
import com.hicc.nagne_backend.domain.user.application.service.UserUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserGetService userGetService;
    private final UserUpdateService userUpdateService;

    @GetMapping("/user/{userId}")
    public UserResponse.UserInfoResponse getUser(@PathVariable Long userId){
        return userGetService.getUser(userId);
    }

    @PostMapping("/user")   // 4개의 필드 다 바꿀 수 있는건가?
    public void updateUser(@RequestBody UserRequest.UserUpdateRequest userUpdateRequest) {
        userUpdateService.updateUser(userUpdateRequest);
    }
}
