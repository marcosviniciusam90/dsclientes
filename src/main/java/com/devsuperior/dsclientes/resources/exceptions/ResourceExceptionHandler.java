package com.devsuperior.dsclientes.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = createStandardError(request, status, "Resource not found", ex.getMessage());
        return ResponseEntity.status(status).body(standardError);
    }

    private StandardError createStandardError(HttpServletRequest request, HttpStatus status, String error, String message) {
        return new StandardError(Instant.now(), status.value(), error, message, request.getRequestURI());
    }
}
