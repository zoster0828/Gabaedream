package com.gabaedream.webapi.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {
    USER_ID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "User Id not found : %s"),
    ALREADY_EXISTS_USER(HttpStatus.BAD_REQUEST.value(), "User Already Exists"),
    INVALID_STATUS(HttpStatus.BAD_REQUEST.value(), "Invalid status : %s"),
    DELIVERY_ID_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "DeliveryCase Id not found : %s"),
    UNREGISTERED_USER(HttpStatus.BAD_REQUEST.value(), "Unregistered user : %s");

    int statusCode;
    String message;
    ResultCode(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
