package com.hicc.nagne_backend.common.security.oauth;

import com.hicc.nagne_backend.common.security.jwt.JwtProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.hicc.nagne_backend.common.consts.ApplicationConst.ACCESS_TOKEN_HEADER;
import static com.hicc.nagne_backend.common.consts.ApplicationConst.REFRESH_TOKEN_HEADER;

/**
 * TODO : 현제 토큰 생성에서 email 정보만을 담고있음. 추후에 유저 역할(ROLE_USER)등 정보를 추가할지 고민.
 */

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Value("${frontend.url}")
    private String FRONTEND_URL;
    private final JwtProvider jwtProvider;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        TokenInfo tokenInfo = generateToken(oAuth2User.getAttribute("email"));
        response.sendRedirect(UriComponentsBuilder.fromUriString(FRONTEND_URL)
                .queryParam(ACCESS_TOKEN_HEADER, tokenInfo.getAccessToken())
                .queryParam(REFRESH_TOKEN_HEADER, tokenInfo.getRefreshToken()).build()
                .encode(StandardCharsets.UTF_8)
                .toUriString());
    }

    private TokenInfo generateToken(String email) {
        String accessToken = jwtProvider.generateAccessToken(email);
        String refreshToken = jwtProvider.generateRefreshToken(email);

        return new TokenInfo(accessToken, refreshToken);
    }


    @Getter
    private static class TokenInfo {
        private final String accessToken;
        private final String refreshToken;

        public TokenInfo(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }

    }
}
