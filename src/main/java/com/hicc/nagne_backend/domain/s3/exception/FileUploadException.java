package com.hicc.nagne_backend.domain.s3.exception;

import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;

public class FileUploadException extends BusinessException {
    public FileUploadException(Error error) {
        super(error);
    }
}
