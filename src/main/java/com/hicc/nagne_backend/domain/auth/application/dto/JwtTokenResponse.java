package com.hicc.nagne_backend.domain.auth.application.dto;

import lombok.Getter;

@Getter
public class JwtTokenResponse {
    private String accessToken;
    private String refreshToken;

    public JwtTokenResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
