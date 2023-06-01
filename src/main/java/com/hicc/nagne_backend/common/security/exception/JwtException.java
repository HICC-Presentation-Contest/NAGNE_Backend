package com.hicc.nagne_backend.common.security.exception;

import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;

public class JwtException extends BusinessException {
	public JwtException(Error error) {
		super(error);
	}
}
