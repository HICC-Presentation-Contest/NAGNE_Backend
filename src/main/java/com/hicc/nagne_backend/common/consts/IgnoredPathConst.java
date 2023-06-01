package com.hicc.nagne_backend.common.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IgnoredPathConst {

	public static final String[] IGNORED_PATHS = {
			"/oauth2/**",
			"/info",
			"/reissue",
			"/favicon.ico"};
}
