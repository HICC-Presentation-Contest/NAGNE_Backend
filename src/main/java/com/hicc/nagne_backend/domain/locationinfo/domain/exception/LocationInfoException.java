package com.hicc.nagne_backend.domain.locationinfo.domain.exception;

import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;

public class LocationInfoException extends BusinessException {
    public LocationInfoException(Error error) {
        super(error);
    }
}
