package com.snailvoyager.springbootnavermap.exception;

import com.snailvoyager.springbootnavermap.resolver.ErrorCode;
import lombok.Getter;

@Getter
public class CustomBaseException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomBaseException(String message, final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomBaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
