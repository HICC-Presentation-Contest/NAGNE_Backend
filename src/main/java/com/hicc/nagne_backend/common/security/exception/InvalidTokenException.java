package com.hicc.nagne_backend.common.security.exception;

import com.hicc.nagne_backend.common.exception.Error;

public class InvalidTokenException extends JwtException{

	public InvalidTokenException(Error error) {
		super(error);
	}
}
