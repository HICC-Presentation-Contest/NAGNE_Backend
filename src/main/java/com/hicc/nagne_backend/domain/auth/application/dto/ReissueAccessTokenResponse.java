package com.hicc.nagne_backend.domain.auth.application.dto;

import lombok.Getter;

@Getter
public class ReissueAccessTokenResponse {
    private String accessToken;

    public ReissueAccessTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
