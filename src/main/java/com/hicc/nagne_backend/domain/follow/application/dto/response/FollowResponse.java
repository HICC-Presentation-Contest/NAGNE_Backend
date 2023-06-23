package com.hicc.nagne_backend.domain.follow.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class FollowResponse {

    @Getter
    public static class FollowInfoResponse {
        @Schema(description = "유저 id", defaultValue = "userId")
        private long userId;
        @Schema(description = "유저 이름", defaultValue = "name")
        private String name;
        @Schema(description = "유저 프로필 사진", defaultValue = "profileImage")
        private String profileImage;

        @Builder
        public FollowInfoResponse(long userId, String name, String profileImage) {
            this.userId = userId;
            this.name = name;
            this.profileImage = profileImage;
        }
    }
}
