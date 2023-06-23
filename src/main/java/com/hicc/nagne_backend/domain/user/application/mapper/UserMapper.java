package com.hicc.nagne_backend.domain.user.application.mapper;

import com.hicc.nagne_backend.domain.user.application.dto.request.UserRequest;
import com.hicc.nagne_backend.domain.user.application.dto.resopnse.UserResponse;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {

    public static UserResponse.UserInfoResponse mapToUserInfoResponse(User user, Long followerCount, Long followingCount) {
        return UserResponse.UserInfoResponse.builder()
                .name(user.getName())
                .description(user.getDescription())
                .profileImageUrl(user.getProfileUrl())
                .followerCount(followerCount)
                .followingCount(followingCount)
                .build();
    }

    public static User mapToUser(UserRequest.UserSignUpRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();
    }

    public static User mapToUser(String name, String email, String profileImageUrl){
        return User.builder()
                .name(name)
                .email(email)
                .profileUrl(profileImageUrl)
                .build();
    }

}
