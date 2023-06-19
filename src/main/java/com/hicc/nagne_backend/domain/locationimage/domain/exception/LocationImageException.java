package com.hicc.nagne_backend.domain.locationimage.domain.exception;

import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;

public class LocationImageException extends BusinessException {
    public LocationImageException(Error error) {
        super(error);
    }
}
