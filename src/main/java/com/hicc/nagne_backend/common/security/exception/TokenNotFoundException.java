package com.hicc.nagne_backend.common.security.exception;

import com.hicc.nagne_backend.common.exception.Error;

public class TokenNotFoundException extends JwtException {
	public TokenNotFoundException(Error error) {
		super(error);
	}
}
