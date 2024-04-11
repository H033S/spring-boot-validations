package com.expeditors.validations.medicalfacility.shared.exception.handler.implementation;

import com.expeditors.validations.medicalfacility.shared.exception.handler.ExceptionHandle;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

@Component
public class DataIntegrityViolationExceptionHandler implements ExceptionHandle<DataIntegrityViolationException> {
    public ProblemDetail handleException(DataIntegrityViolationException exception) {

        if(!(exception.getCause() instanceof ConstraintViolationException constraintViolationException)){

            return new GlobalExceptionHandler()
                    .handleException(exception);
        }

        String message = determineConstraintViolationMessage(
                constraintViolationException.getMessage());

        return ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                message
        );
    }

    private String determineConstraintViolationMessage(String message) {
        return "SSN must be unique";
    }
}
