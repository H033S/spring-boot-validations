package com.expeditors.validations.medicalfacility.shared.exception.handler.implementation;

import com.expeditors.validations.medicalfacility.shared.exception.handler.ExceptionHandle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

@Component
public class GlobalExceptionHandler implements ExceptionHandle<Exception> {

    public ProblemDetail handleException(Exception exception) {
        System.out.println(
                "Exception: " + exception.getClass().getSimpleName() + "\n" +
                "Message: " + exception.getMessage());

        return ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Error Global"
        );
    }
}
