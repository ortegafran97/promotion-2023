package com.promotion.categoryservice.exceptions;

import com.promotion.categoryservice.exceptions.clases.AlreadyExistsException;
import com.promotion.categoryservice.exceptions.clases.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> notFoundHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("No encontrado", e.getMessage(),"404",req.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> alreadyExistsHandler(HttpServletRequest req, Exception e){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("Registro existente", e.getMessage(),null,req.getRequestURI()),HttpStatus.BAD_REQUEST);
    }
}
