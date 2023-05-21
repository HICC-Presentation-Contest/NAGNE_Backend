package com.hicc.nagne_backend.domain.follow.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class FollowResponse {

    @Getter
    public static class FollowInfoResponse {
        private long userId;

        @Builder
        public FollowInfoResponse(long userId) {
            this.userId = userId;
        }
    }
}
