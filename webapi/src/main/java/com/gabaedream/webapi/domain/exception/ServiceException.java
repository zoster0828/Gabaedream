package com.gabaedream.webapi.domain.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ContextedRuntimeException;

import java.util.HashMap;
import java.util.Map;

public class ServiceException extends ContextedRuntimeException {
    ResultCode resultCode;
    String message;
    public ServiceException(ResultCode resultCode, Object... additionalMessage) {
        super(resultCode.message);
        this.resultCode = resultCode;
        this.message = String.format(resultCode.message, additionalMessage);
    }

    public String toResponseString() throws JsonProcessingException {
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", this.resultCode);
        result.put("message", this.message);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(result);
        return jsonStr;
    }

    public int getStatusCode(){
        return this.resultCode.getStatusCode();
    }
}

