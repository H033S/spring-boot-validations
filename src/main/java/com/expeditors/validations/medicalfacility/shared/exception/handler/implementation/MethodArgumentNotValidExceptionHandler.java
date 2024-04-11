package com.expeditors.validations.medicalfacility.shared.exception.handler.implementation;

import com.expeditors.validations.medicalfacility.dto.ConstraintViolation;
import com.expeditors.validations.medicalfacility.shared.exception.handler.ExceptionHandle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Objects;


@Component
public class MethodArgumentNotValidExceptionHandler implements ExceptionHandle<MethodArgumentNotValidException> {

    public ProblemDetail handleException(MethodArgumentNotValidException exception) {

        ProblemDetail validationProblemDetail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST,
                        "Validation Error"
                );

        List<ConstraintViolation> errors = exception.getFieldErrors()
                .stream()
                .map(violation -> ConstraintViolation
                        .builder()
                        .message(violation.getDefaultMessage())
                        .fieldName(violation.getField())
                        .rejectedValue(
                                Objects.isNull(violation.getRejectedValue()) ?
                                        "null" :
                                        violation.getRejectedValue().toString()
                        )
                        .build())
                .toList();

        validationProblemDetail.setProperty("errors", errors);
        return validationProblemDetail;
    }
}
