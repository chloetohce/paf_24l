package paf.lecture.paf_24l.controller;

import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import paf.lecture.paf_24l.exception.AccountInactiveException;
import paf.lecture.paf_24l.exception.ErrorMessage;
import paf.lecture.paf_24l.exception.InsufficientBalanceException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * Intercepts when the general exception is thrown
     * Request: coming from which IP or endpoint
     * Response: what you want to send back
     */
    @ExceptionHandler({Exception.class, AccountInactiveException.class, AccountNotFoundException.class, InsufficientBalanceException.class})
    public ResponseEntity<ErrorMessage> handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        ErrorMessage msg = new ErrorMessage(response.getStatus(), e.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<>(msg, HttpStatus.valueOf(response.getStatus()));
    }
    
}
