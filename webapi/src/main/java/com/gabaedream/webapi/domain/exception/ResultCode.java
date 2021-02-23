package com.gabaedream.webapi.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {
    USER_ID_NOT_FOUND(HttpStatus.NO_CONTENT.value(), "Id not found %s");

    int statusCode;
    String message;
    ResultCode(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
