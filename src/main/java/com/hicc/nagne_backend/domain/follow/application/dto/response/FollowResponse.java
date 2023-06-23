package com.hicc.nagne_backend.domain.follow.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class FollowResponse {

    @Getter
    public static class FollowInfoResponse {
        @Schema(description = "팔로우한 유저 id")
        private long userId;

        @Schema(description = "팔로우한 유저 이름")
        private String name;
        @Schema(description = "팔로우한 유저 프로필 사진")
        private String profileImage;

        @Builder
        public FollowInfoResponse(long userId, String name, String profileImage) {
            this.userId = userId;
            this.name = name;
            this.profileImage = profileImage;
        }
    }
}
