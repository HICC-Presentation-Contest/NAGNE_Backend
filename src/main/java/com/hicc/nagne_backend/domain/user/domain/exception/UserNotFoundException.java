package com.hicc.nagne_backend.domain.user.domain.exception;

import com.hicc.nagne_backend.common.exception.Error;

public class UserNotFoundException extends UserException{
    public UserNotFoundException(Error error) {
        super(error);
    }
}
