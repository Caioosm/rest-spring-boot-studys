package com.estudos.__first_steps.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.estudos.__first_steps.exceptions.ExceptionResponse;
import com.estudos.__first_steps.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //método para exceções mais genéricas 
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest wRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            ex.getMessage(),
            wRequest.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Método para exceção específica para operações não suportadas, como por exemplo passar uma letra no parâmetro ao invés de um número
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(Exception ex, WebRequest wRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(), 
            ex.getMessage(),
            wRequest.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
