package com.gabaedream.webapi.domain.exception;

public class ServiceException extends Throwable {
    ResultCode resultCode;

    public ServiceException(ResultCode resultCode, String... additionalMessage) {

    }

    public String toResponseString() {
        return null;
    }
}
