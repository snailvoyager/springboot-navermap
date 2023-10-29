package com.snailvoyager.springbootnavermap.exception;

import com.snailvoyager.springbootnavermap.resolver.ErrorCode;

public class NotFoundException extends CustomBaseException {
    public NotFoundException(final ErrorCode errorCode) {
        super(errorCode.getMessage(), errorCode);
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
