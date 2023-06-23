package com.hicc.nagne_backend.domain.auth.presentation;

import com.hicc.nagne_backend.common.consts.ApplicationConst;
import com.hicc.nagne_backend.common.exception.dto.ErrorResponse;
import com.hicc.nagne_backend.common.security.jwt.JwtProvider;
import com.hicc.nagne_backend.common.util.HeaderUtils;
import com.hicc.nagne_backend.common.util.SecurityUtils;
import com.hicc.nagne_backend.domain.auth.application.dto.JwtTokenResponse;
import com.hicc.nagne_backend.domain.auth.application.dto.ReissueAccessTokenResponse;
import com.hicc.nagne_backend.domain.auth.application.service.GoogleOAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final GoogleOAuthService googleOAuthService;
    private final JwtProvider jwtProvider;

    @Operation(summary = "토큰 재발급", description = "토큰 재발급")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "토큰 재발급 성공"),
            @ApiResponse(responseCode = "400", description = "토큰 재발급 실패",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/login/reissue")
    public ReissueAccessTokenResponse reissue() {
        final String header = HeaderUtils.getHeader(ApplicationConst.REFRESH_TOKEN_HEADER);
        final String accessToken = SecurityUtils.validateHeaderAndGetToken(header);
        return new ReissueAccessTokenResponse(ApplicationConst.JWT_AUTHORIZATION_TYPE+jwtProvider.reIssue(accessToken));
    }

    @Operation(summary = "구글 로그인", description = "구글 로그인")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "구글 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "구글 로그인 실패",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/login/oauth2/google")
    public JwtTokenResponse googleLogin(HttpServletRequest request, @RequestParam("code") String code) {
        return googleOAuthService.login(request, code);
    }
}
