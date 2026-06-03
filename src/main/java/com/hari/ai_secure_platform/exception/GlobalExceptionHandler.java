package com.hari.ai_secure_platform.exception;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleException(Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("status", "FAILED");
        error.put("error", ex.getMessage());

        return error;
    }
}