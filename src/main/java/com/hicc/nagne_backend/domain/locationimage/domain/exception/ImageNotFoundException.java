package com.hicc.nagne_backend.domain.locationimage.domain.exception;

import com.hicc.nagne_backend.common.exception.Error;

public class ImageNotFoundException extends LocationImageException{
    public ImageNotFoundException(Error error) {
        super(error);
    }
}
