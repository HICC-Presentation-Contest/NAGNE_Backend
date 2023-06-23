package com.hicc.nagne_backend.domain.follow.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class FollowRequest {

    @Getter
    @NoArgsConstructor
    public static class FollowCreateRequest {
        @Schema(description = "팔로우 요청을 받은 유저 id", defaultValue = "receiverId")
        private long receiverId;

        @Builder
        public FollowCreateRequest(long receiverId) {
            this.receiverId = receiverId;
        }
    }

}
