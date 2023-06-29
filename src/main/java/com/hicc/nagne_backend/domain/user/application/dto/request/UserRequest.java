package com.hicc.nagne_backend.domain.user.application.dto.request;

import com.hicc.nagne_backend.domain.user.domain.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {

    @Getter
    @NoArgsConstructor
    public static class UserUpdateRequest {
        @Schema(description = "유저 id", defaultValue = "userId")
        private Long userId;
        @Schema(description = "유저 이름", defaultValue = "name")
        private String name;
        @Schema(description = "유저 자기소개", defaultValue = "description")
        private String description;
        @Schema(description = "유저 이메일", defaultValue = "email")
        private String email;
        @Schema(description = "유저 프로필 사진", defaultValue = "profileUrl")
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

    @Getter
    public static class UserSignUpRequest{
        @Schema(description = "유저 이름", defaultValue = "name")
        private String name;
        @Schema(description = "유저 이메일", defaultValue = "email")
        private String email;

        @Builder
        public UserSignUpRequest(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class UserCreateRequest{
        @Schema(description = "유저 거주지역", defaultValue = "homeAddress")
        private String homeAddress;
        @Schema(description = "유저 성별", defaultValue = "gender")
        private Gender gender;

        @Builder
        public UserCreateRequest(String homeAddress, Gender gender) {
            this.homeAddress = homeAddress;
            this.gender = gender;
        }
    }
}
