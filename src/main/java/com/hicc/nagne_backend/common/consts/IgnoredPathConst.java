package com.hicc.nagne_backend.common.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IgnoredPathConst {

	public static final String[] IGNORED_PATHS = {
			"/oauth2/**",
			"/swagger-ui/index.html",
			"/swagger-ui.html",
			"/swagger-ui/**",
			"/v3/api-docs/**",
			"/info",
			"/login/oauth2/google",
			"/reissue",
			"/favicon.ico"};
}
