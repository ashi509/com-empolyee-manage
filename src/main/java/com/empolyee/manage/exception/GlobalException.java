package com.empolyee.manage.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalException {
    @ExceptionHandler(GenericException.class)
    ResponseEntity<?>handleGenericException(GenericException genericException ){
        log.error(genericException.getErrorMessage());
        return ResponseEntity.status(genericException.getStatusCode()).body(genericException.getErrorMessage());

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String,String>>handleMethodArgumentNotFoundException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> response=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String errorStatus= ((FieldError)error).getField();
            String errorMessage= error.getDefaultMessage();
            response.put(errorStatus,errorMessage);
        });
        return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);

    }


}
