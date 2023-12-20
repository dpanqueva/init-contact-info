package com.invexdijin.init.contact.info.infrastructure.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionErrorHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Map<String, Object>> badRequest(MethodArgumentTypeMismatchException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "UPS! Bad request, date must have the format yyyy-mm-ddHH:mm:ss. Example: 2020-06-1410:10:00");
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Map<String, Object>> notFound(NotFoundException e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        log.error("Not found: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, Object>> internalServerException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "UPS! Unexpected error, contact system administrator");
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler({AttemptsLimitException.class})
    public ResponseEntity<Map<String, Object>> attemptsLimitException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message","You have exceeded your allowed attempts limit. Try again tomorrow.");
        response.put("code", "attempts-limit-exception");
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


    @ExceptionHandler({WithPaymentReferenceException.class})
    public ResponseEntity<Map<String, Object>> withPaymentReferenceException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("message","You have a reference payment. Try again.");
        response.put("code", "with-payment-reference");
        log.error("Unexpected error: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public ResponseEntity<Map<String, Object>> notFoundedResource(Exception e){
        Map<String, Object> response = new HashMap<>();
        response.put("message","Not found resource");
        response.put("code", "sweet-alert-not-found");
        log.error("Not found: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler({HttpClientErrorException.BadRequest.class})
    public ResponseEntity<Map<String, Object>> badRequestException(Exception e){
        Map<String, Object> response = new HashMap<>();
        response.put("message",e.getMessage());
        response.put("code", "attempts-limit-exception");
        log.error("BadRequest: ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
