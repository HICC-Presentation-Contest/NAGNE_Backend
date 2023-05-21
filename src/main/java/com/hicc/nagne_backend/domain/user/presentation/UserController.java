package com.hicc.nagne_backend.domain.user.presentation;

import com.hicc.nagne_backend.domain.user.application.dto.UserResponse;
import com.hicc.nagne_backend.domain.user.application.service.UserGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserGetService userGetService;
    @GetMapping("/user/{tripId}")
    public UserResponse.UserInfoResponse getUser(@PathVariable Long tripId){
        return userGetService.getUser(tripId);
    }

}
