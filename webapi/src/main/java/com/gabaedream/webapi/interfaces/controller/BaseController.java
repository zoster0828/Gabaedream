package com.gabaedream.webapi.interfaces.controller;

import com.gabaedream.webapi.domain.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestControllerAdvice
@RequestMapping(produces="application/json;charset=UTF-8")
public abstract class BaseController {

    @ExceptionHandler(ServiceException.class)
    public void exceptionHandler(ServiceException serviceException, HttpServletResponse response) throws IOException {
        String responseString = serviceException.toResponseString();
        response.setStatus(serviceException.getStatusCode());
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.print(responseString);
    }
}
