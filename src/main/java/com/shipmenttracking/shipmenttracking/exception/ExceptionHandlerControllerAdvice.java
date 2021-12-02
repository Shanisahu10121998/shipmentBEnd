package com.shipmenttracking.shipmenttracking.exception;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse badRequest(BusinessException exception, HttpServletRequest request)
    {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        log.info(" ExceptionResponse :{}" +error);
        System.out.println( " ExceptionResponse :{}" +error);
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public @ResponseBody Map<String,String> badGateway(Exception exception, HttpServletRequest request)
    {
        Map<String,String> exc = new HashMap<>();
        exc.put("errorMessage",exception.getMessage());
        exc.put("requestedURI",request.getRequestURI());
       /* exce.put("method",request.getMethod());
        exce.put("sessionId",request.getRequestedSessionId());*/

        return exc;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody Map<String,String> notFound(RuntimeException exception, HttpServletRequest request)
    {
        Map<String,String> exce = new HashMap<>();
        exce.put("errorMessage",exception.getMessage());
        exce.put("requestedURI",request.getRequestURI());
        exce.put("method",request.getMethod());
        exce.put("sessionId",request.getRequestedSessionId());
        return exce;
    }


}
