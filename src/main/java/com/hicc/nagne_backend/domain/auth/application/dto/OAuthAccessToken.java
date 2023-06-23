package com.hicc.nagne_backend.domain.auth.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthAccessToken {

    private String accessToken;
    private int expiresIn;
    private String idToken;
    private String tokenType;

    public OAuthAccessToken(String accessToken, int expiresIn, String idToken, String tokenType) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.idToken = idToken;
        this.tokenType = tokenType;
    }

    @Override
    public String toString() {
        return "OAuthAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", idToken='" + idToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
