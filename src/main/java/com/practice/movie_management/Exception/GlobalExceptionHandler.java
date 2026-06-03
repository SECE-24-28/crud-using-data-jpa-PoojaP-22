package com.practice.movie_management.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) //Whenever ResourceNotFoundException occurs, call this method.
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex, //Contains exception information.
            HttpServletRequest request){ //Represents incoming HTTP request.

        ErrorResponse error = new ErrorResponse(  //the structure for error output
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), //404
                ex.getMessage(),  // message format written in ResourceNotFound
                "NOT FOUND", //(or)  HttpStatus.NOT_FOUND.getReasonPhrase()
                request.getRequestURI() //this is defined inside HttpServerletRequest
        );

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIndexError(
            IllegalArgumentException ex,
            HttpServletRequest request ){

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "IllegalArgument",
                request.getRequestURI()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(
            MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        ));

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}
