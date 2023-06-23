package com.hicc.nagne_backend.domain.follow.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class FollowRequest {

    @Getter
    @NoArgsConstructor
    public static class FollowCreateRequest {
        private long receiverId;

        @Builder
        public FollowCreateRequest(long receiverId) {
            this.receiverId = receiverId;
        }
    }

}
