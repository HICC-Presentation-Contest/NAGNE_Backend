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

    public JwtTokenResponse login(String code){
        final OAuthAccessToken oAuthAccessToken;
        final OAuthUserProfile googleUserProfile;
        try {
            oAuthAccessToken = getGoogleAccessToken(code);
            googleUserProfile = getGoogleUserProfile(oAuthAccessToken);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new InvalidTokenException(Error.INVALID_TOKEN);
        }

        if(!userQueryService.existsByEmail(googleUserProfile.getEmail())) {
            User user = UserMapper.mapToUser(googleUserProfile.getName(), googleUserProfile.getEmail(), googleUserProfile.getPicture());
            userSaveService.save(user);
        }

        String accessToken =ApplicationConst.JWT_AUTHORIZATION_TYPE+jwtProvider.generateAccessToken(googleUserProfile.getEmail());
        String refreshToken = ApplicationConst.JWT_AUTHORIZATION_TYPE+jwtProvider.generateRefreshToken(googleUserProfile.getEmail());

        return new JwtTokenResponse(accessToken, refreshToken);
    }

    private OAuthUserProfile getGoogleUserProfile(OAuthAccessToken accessToken) throws JsonProcessingException {
        String userProfileUri = googleOAuthProperties.getGoogleUserInfoUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken.getAccessToken());
        log.info("httpHeaders: {}", httpHeaders);
        log.info("accessToken : {}", accessToken);
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> userInfoResponse = restTemplate.exchange(userProfileUri, HttpMethod.GET, httpEntity, String.class);

        String userInfo = userInfoResponse.getBody();
        log.info("userInfo: {}", userInfo);
        return objectMapper.readValue(userInfo, OAuthUserProfile.class);
    }

    private OAuthAccessToken getGoogleAccessToken(String accessCode) throws JsonProcessingException {
        String code = getAuthorizationCode(accessCode);

        String tokenUri = googleOAuthProperties.getGoogleTokenUri();
        String clientId = googleOAuthProperties.getClientId();
        String clientSecret = googleOAuthProperties.getClientSecret();
        String redirectUri = googleOAuthProperties.getRedirectUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        MultiValueMap<String, String> httpBody = new LinkedMultiValueMap<>();
        httpBody.add("code", code);
        httpBody.add("client_id", clientId);
        httpBody.add("client_secret", clientSecret);
        httpBody.add("redirect_uri", redirectUri);
        httpBody.add("grant_type", "authorization_code");

        log.info("httpBody: {}", httpBody);

        HttpEntity<MultiValueMap<String, String>> requestToken = new HttpEntity<>(httpBody, httpHeaders);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUri, requestToken, String.class);
        log.info("response: {}", response);
        return objectMapper.readValue(response.getBody(), OAuthAccessToken.class);
    }

    private String getAuthorizationCode(String code){
//        final String authorization = request.getHeader(ApplicationConst.ACCESS_TOKEN_HEADER);
//        if(!StringUtils.hasText(authorization)){
//            throw new IllegalArgumentException("Authorization Header가 없습니다.");
//        }

//        String[] tokens = StringUtils.delimitedListToStringArray(authorization, " ");
//        if (tokens.length != 2 || !"Bearer".equals(tokens[0])) {
//            throw new InvalidTokenException(Error.INVALID_TOKEN);
//        }
//        return tokens[1];
        return code;
    }
}
