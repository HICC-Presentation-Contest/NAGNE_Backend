package com.hicc.nagne_backend.domain.follow.application.dto.request;

import lombok.Builder;
import lombok.Getter;

public class FollowRequest {

    @Getter
    public static class FollowCreateRequest {
        private long userId;
        private long receiverId;

        @Builder
        public FollowCreateRequest(long userId, long receiverId) {
            this.userId = userId;
            this.receiverId = receiverId;
        }
    }

}
