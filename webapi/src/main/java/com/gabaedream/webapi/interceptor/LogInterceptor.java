package com.gabaedream.webapi.interceptor;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {

    private static final Logger ACC_LOG = LoggerFactory.getLogger("ACC");

    private long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long elasedTime = System.currentTimeMillis() - startTime;
        ACC_LOG.info(new AccessLogInfo(request.getRequestURI(), elasedTime, response.getStatus()).toString());
    }

    @AllArgsConstructor
    @ToString
    public static class AccessLogInfo {

        private final String requestUri;
        private final long elapsedTime;
        private final int statusCode;
    }
}