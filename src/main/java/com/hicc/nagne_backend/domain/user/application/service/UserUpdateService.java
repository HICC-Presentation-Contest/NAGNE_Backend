package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.domain.user.application.dto.request.UserRequest;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserUpdateService {

    private final UserQueryService userQueryService;

    public void updateUser(UserRequest.UserUpdateRequest userUpdateRequest) {
        Long userId = userUpdateRequest.getUserId();
        User user = userQueryService.findById(userId);

        String name = userUpdateRequest.getName();
        String email = userUpdateRequest.getEmail();
        String description = userUpdateRequest.getDescription();
        String profileUrl = userUpdateRequest.getProfileUrl();

        user.updateUserInfo(name, description, email, profileUrl);

    }
}
