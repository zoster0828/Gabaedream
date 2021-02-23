package com.gabaedream.webapi.domain.exception;

import org.springframework.http.HttpStatus;

public enum ResultCode {
    USER_ID_NOT_FOUND(HttpStatus.NO_CONTENT.value(), "Id not found %s");

    int statusCode;
    String message;
    ResultCode(int statusCode, String... additional){
        this.statusCode = statusCode;
        this.message = String.format(message, additional);
    }
}
