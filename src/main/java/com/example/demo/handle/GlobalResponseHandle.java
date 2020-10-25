package com.example.demo.handle;

import com.example.demo.util.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author cui
 */
@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalResponseHandle implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        final String parameterTypeName = methodParameter.getParameterType().getName();
        return !GlobalResponse.class.getName().equals(parameterTypeName) && !ResponseEntity.class.getName().equals(parameterTypeName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        final String parameterTypeName = methodParameter.getParameterType().getName();
        if ("void".equals(parameterTypeName)) {
            return GlobalResponse.success(null);
        }
        if (!mediaType.includes(MediaType.APPLICATION_JSON)) {
            return body;
        }
        if (GlobalResponse.class.getName().equals(parameterTypeName)) {
            return body;
        }
        return GlobalResponse.success(body);
    }
}