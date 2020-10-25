package com.example.demo.handle;

import com.example.demo.enums.ErrorEnum;
import com.example.demo.util.FaultException;
import com.example.demo.util.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * @author cui
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FaultException.class)
    public GlobalResponse<Object> handlerException(FaultException e) {
        log.error(e.getMessage(), e);
        return GlobalResponse.fail(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GlobalResponse<Object> handlerException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        log.error(e.getMessage(), e);
        return GlobalResponse.fail(message);
    }

    @ExceptionHandler(Exception.class)
    public <T> GlobalResponse<T> handlerException(Exception e) {
        log.error(e.getMessage(), e);
        return GlobalResponse.fail(ErrorEnum.SYS_ERROR.getCode(),ErrorEnum.SYS_ERROR.getMsg());
    }
}