package com.hicc.nagne_backend.domain.user.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.user.application.dto.request.UserRequest;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UserUpdateUseCase {

    private final UserUtils userUtils;
    private final UserQueryService userQueryService;

    public void updateUser(final UserRequest.UserUpdateRequest userUpdateRequest) {
        final User user = userUtils.getUser();

        String name = userUpdateRequest.getName();
        String email = userUpdateRequest.getEmail();
        String description = userUpdateRequest.getDescription();
        String profileUrl = userUpdateRequest.getProfileUrl();

        user.updateUserInfo(name, description, email, profileUrl);

    }
}
