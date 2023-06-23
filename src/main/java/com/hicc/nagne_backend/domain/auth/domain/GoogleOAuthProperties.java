package com.hicc.nagne_backend.domain.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "oauth2.google")
public class GoogleOAuthProperties {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String googleTokenUri;
    private String googleUserInfoUri;

}
