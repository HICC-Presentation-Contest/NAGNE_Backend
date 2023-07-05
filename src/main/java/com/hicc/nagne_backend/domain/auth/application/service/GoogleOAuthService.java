package com.hicc.nagne_backend.domain.auth.application.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.consts.ApplicationConst;
import com.hicc.nagne_backend.common.exception.Error;
import com.hicc.nagne_backend.common.security.exception.InvalidTokenException;
import com.hicc.nagne_backend.common.security.jwt.JwtProvider;
import com.hicc.nagne_backend.domain.auth.application.dto.JwtTokenResponse;
import com.hicc.nagne_backend.domain.auth.application.dto.OAuthAccessToken;
import com.hicc.nagne_backend.domain.auth.application.dto.OAuthUserProfile;
import com.hicc.nagne_backend.domain.auth.domain.GoogleOAuthProperties;
import com.hicc.nagne_backend.domain.user.application.mapper.UserMapper;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import com.hicc.nagne_backend.domain.user.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@UseCase
@Transactional
@RequiredArgsConstructor
public class GoogleOAuthService {

    private final GoogleOAuthProperties googleOAuthProperties;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final UserQueryService userQueryService;
    private final UserSaveService userSaveService;
    private final JwtProvider jwtProvider;

    public JwtTokenResponse loginWithAccessToken(final String accessToken) {
        return generateTokenWithOAuthAccessToken(accessToken);
    }

    public JwtTokenResponse login(final String code) {
        final OAuthAccessToken oAuthAccessToken;
        try{
            oAuthAccessToken = getGoogleAccessToken(code);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InvalidTokenException(Error.INVALID_TOKEN);
        }
        return generateTokenWithOAuthAccessToken(oAuthAccessToken.getAccessToken());
    }

    private JwtTokenResponse generateTokenWithOAuthAccessToken(final String accessToken) {
        final OAuthUserProfile googleUserProfile;
        try {
            googleUserProfile = getGoogleUserProfile(accessToken);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InvalidTokenException(Error.INVALID_TOKEN);
        }

        validateUserExist(googleUserProfile);

        final Result result = generateJwtToken(googleUserProfile);

        return new JwtTokenResponse(result.newAccessToken, result.newRefreshToken);
    }

    private OAuthUserProfile getGoogleUserProfile(final String accessToken) throws JsonProcessingException {
        final String userProfileUri = googleOAuthProperties.getGoogleUserInfoUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> userInfoResponse = restTemplate.exchange(userProfileUri, HttpMethod.GET, httpEntity, String.class);

        String userInfo = userInfoResponse.getBody();
        return objectMapper.readValue(userInfo, OAuthUserProfile.class);
    }

    private OAuthAccessToken getGoogleAccessToken(final String accessCode) throws JsonProcessingException {
        final String code = getAuthorizationCode(accessCode);

        final String tokenUri = googleOAuthProperties.getGoogleTokenUri();
        final String clientId = googleOAuthProperties.getClientId();
        final String clientSecret = googleOAuthProperties.getClientSecret();
        final String redirectUri = googleOAuthProperties.getRedirectUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        MultiValueMap<String, String> httpBody = new LinkedMultiValueMap<>();
        httpBody.add("code", code);
        httpBody.add("client_id", clientId);
        httpBody.add("client_secret", clientSecret);
        httpBody.add("redirect_uri", redirectUri);
        httpBody.add("grant_type", "authorization_code");


        HttpEntity<MultiValueMap<String, String>> requestToken = new HttpEntity<>(httpBody, httpHeaders);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUri, requestToken, String.class);
        return objectMapper.readValue(response.getBody(), OAuthAccessToken.class);
    }

    private String getAuthorizationCode(final String code) {
        return code;
    }

    private void validateUserExist(final OAuthUserProfile googleUserProfile) {
        if (!userQueryService.existsByEmail(googleUserProfile.getEmail())) {
            User user = UserMapper.mapToUser(googleUserProfile.getName(), googleUserProfile.getEmail(), googleUserProfile.getPicture());
            userSaveService.save(user);
        }
    }

    private Result generateJwtToken(final OAuthUserProfile googleUserProfile) {
        final String newAccessToken = ApplicationConst.JWT_AUTHORIZATION_TYPE + jwtProvider.generateAccessToken(googleUserProfile.getEmail());
        final String newRefreshToken = ApplicationConst.JWT_AUTHORIZATION_TYPE + jwtProvider.generateRefreshToken(googleUserProfile.getEmail());
        final Result result = new Result(newAccessToken, newRefreshToken);
        return result;
    }

    private static class Result {
        public final String newAccessToken;
        public final String newRefreshToken;

        public Result(String newAccessToken, String newRefreshToken) {
            this.newAccessToken = newAccessToken;
            this.newRefreshToken = newRefreshToken;
        }
    }
}
