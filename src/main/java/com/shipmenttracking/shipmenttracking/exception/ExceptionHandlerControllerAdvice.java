package com.shipmenttracking.shipmenttracking.exception;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse badRequest(BusinessException exception, HttpServletRequest request)
    {
        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());
        return error;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public @ResponseBody Map<String,String> badGateway(Exception exception, HttpServletRequest request)
    {
        Map<String,String> ex = new HashMap<>();
        ex.put("errorMessage",exception.getMessage());
        ex.put("requestedURI",request.getRequestURI());
        return ex;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody Map<String,String> notFound(RuntimeException exception, HttpServletRequest request)
    {
        Map<String,String> exce = new HashMap<>();
        exce.put("errorMessage",exception.getMessage());
        exce.put("requestedURI",request.getRequestURI());
        exce.put("method",request.getMethod());
        return exce;
    }

}
