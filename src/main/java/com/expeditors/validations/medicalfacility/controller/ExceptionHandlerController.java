package com.expeditors.validations.medicalfacility.controller;

import com.expeditors.validations.medicalfacility.shared.exception.handler.ExceptionHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "com.expeditors.validations.medicalfacility")
public class ExceptionHandlerController {

    @Autowired
    private ExceptionHandle<Exception> exceptionHandler;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleException(
            Exception exception){

        return exceptionHandler
                .handleException(exception);
    }

    @Autowired
    private ExceptionHandle<MethodArgumentNotValidException> methodArgumentNotValidExceptionHandler;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        return methodArgumentNotValidExceptionHandler
                .handleException(exception);
    }


    @Autowired
    private ExceptionHandle<DataIntegrityViolationException> dataIntegrityViolationExceptionHandler;

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleDataIntegrityViolationException(
            DataIntegrityViolationException exception){

        return dataIntegrityViolationExceptionHandler
                .handleException(exception);
    }
}
