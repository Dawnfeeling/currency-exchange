package com.example.exchange.service.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //유효성 검사 실패
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = ex.getBindingResult().getFieldErrors().stream()
                        .map(error -> {
                            Map<String, String> errorDetails = new HashMap<>();
                            errorDetails.put("errorField", error.getField());
                            errorDetails.put("errorMessage", error.getDefaultMessage());
                            return errorDetails;
                        }).toList();

        return ResponseEntity.badRequest().body(errors);
    }

    //각 데이터가 존재하는지 검사
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, String>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("errorCode", ex.getStatusCode().toString().split(" ")[0]);
        error.put("errorStatus", ex.getStatusCode().toString().split(" ")[1]);
        error.put("errorMessage", ex.getReason());

        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }
}
