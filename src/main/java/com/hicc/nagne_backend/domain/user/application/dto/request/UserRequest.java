package com.hicc.nagne_backend.domain.user.application.dto.request;

import lombok.Builder;
import lombok.Getter;

public class UserRequest {

    @Getter
    public static class UserUpdateRequest {
        private Long userId;
        private String name;
        private String description;
        private String email;
        private String profileUrl;

        @Builder
        public UserUpdateRequest(Long userId, String name, String description, String email, String profileUrl) {
            this.userId = userId;
            this.name = name;
            this.description = description;
            this.email = email;
            this.profileUrl = profileUrl;
        }
    }
}
