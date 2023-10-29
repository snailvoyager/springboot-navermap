package com.snailvoyager.springbootnavermap.resolver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E1", "Invalid input value"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E2", "Method not allowed"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E3", "Internal server error"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "E4", "Resource not found");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
