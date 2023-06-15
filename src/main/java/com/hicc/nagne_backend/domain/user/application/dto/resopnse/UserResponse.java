package com.hicc.nagne_backend.domain.user.application.dto.resopnse;

import lombok.Builder;
import lombok.Getter;

public class UserResponse {

    @Getter
    public static class UserInfoResponse {

        private String name;
        private String description;
        private Long followerCount;
        private Long followingCount;

        @Builder
        public UserInfoResponse(String name, String description, Long followerCount, Long followingCount) {
            this.name = name;
            this.description = description;
            this.followerCount = followerCount;
            this.followingCount = followingCount;
        }
    }
}
