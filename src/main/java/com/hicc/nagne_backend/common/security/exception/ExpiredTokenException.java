package com.hicc.nagne_backend.common.security.exception;

import com.hicc.nagne_backend.common.exception.Error;

public class ExpiredTokenException extends JwtException{
	public ExpiredTokenException(Error error) {
		super(error);
	}
}
