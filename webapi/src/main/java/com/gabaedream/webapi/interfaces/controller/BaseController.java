package com.gabaedream.webapi.interfaces.controller;

import com.gabaedream.webapi.domain.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BaseController {

    @ExceptionHandler(ServiceException.class)
    public void exceptionHandler(ServiceException serviceException, HttpServletResponse response) throws IOException {
        String responseString = serviceException.toResponseString();
        PrintWriter writer = response.getWriter();
        writer.print(responseString);
    }
}
