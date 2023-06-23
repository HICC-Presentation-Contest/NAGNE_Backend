package com.hicc.nagne_backend.domain.user.application.dto.resopnse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class UserResponse {

    @Getter
    public static class UserInfoResponse {

        @Schema(description = "유저 이름")
        private String name;
        @Schema(description = "유저 설명")
        private String description;
        @Schema(description = "유저 프로필 사진")
        private String profileImageUrl;
        @Schema(description = "팔로워 수")
        private Long followerCount;
        @Schema(description = "팔로잉 수")
        private Long followingCount;

        @Builder
        public UserInfoResponse(String name, String description, String profileImageUrl, Long followerCount, Long followingCount) {
            this.name = name;
            this.description = description;
            this.profileImageUrl = profileImageUrl;
            this.followerCount = followerCount;
            this.followingCount = followingCount;
        }
    }
}
