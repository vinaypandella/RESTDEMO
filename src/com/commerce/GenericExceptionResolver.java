package com.commerce;


import java.lang.reflect.Method;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

public class GenericExceptionResolver extends ExceptionHandlerExceptionResolver {
    private final Object globalExceptionHandler;
    private final ExceptionHandlerMethodResolver globalExceptionResolver;

    public GenericExceptionResolver(Object globalExceptionHandler) {
        this.globalExceptionHandler = globalExceptionHandler;
        this.globalExceptionResolver = new ExceptionHandlerMethodResolver(globalExceptionHandler.getClass());
    }

    @Override
    protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
        ServletInvocableHandlerMethod controllerScopeHandler = super.getExceptionHandlerMethod(handlerMethod, exception);
        if (controllerScopeHandler == null) {
            return globalExceptionHandlerMethod(exception);
        }
        return controllerScopeHandler;
    }

    private ServletInvocableHandlerMethod globalExceptionHandlerMethod(Exception exception) {
        Method method = globalExceptionResolver.resolveMethod(exception);
        return method != null ? new ServletInvocableHandlerMethod(globalExceptionHandler, method) : null;
    }
}
