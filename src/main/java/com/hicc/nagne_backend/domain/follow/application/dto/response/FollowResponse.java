package com.hicc.nagne_backend.domain.follow.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class FollowResponse {

    @Getter
    public static class FollowInfoResponse {
        private long userId;

        private String name;
        private String profileImage;

        @Builder
        public FollowInfoResponse(long userId, String name, String profileImage) {
            this.userId = userId;
            this.name = name;
            this.profileImage = profileImage;
        }
    }
}
