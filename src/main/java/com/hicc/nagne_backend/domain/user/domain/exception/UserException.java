package com.hicc.nagne_backend.domain.user.domain.exception;

import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;

public class UserException extends BusinessException {
    public UserException(Error error) {
        super(error);
    }
}
