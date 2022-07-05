package com.yuenwk.common.exception;

import com.yuenwk.common.api.IErrorCode;
import lombok.Getter;

public class ApiException extends RuntimeException {

    @Getter
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

}