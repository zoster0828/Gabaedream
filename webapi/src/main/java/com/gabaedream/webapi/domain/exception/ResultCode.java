package com.gabaedream.webapi.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {
    USER_ID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Id not found %s"),
    ALREADY_EXISTS_USER(HttpStatus.BAD_REQUEST.value(), "User Already Exists");


    int statusCode;
    String message;
    ResultCode(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
