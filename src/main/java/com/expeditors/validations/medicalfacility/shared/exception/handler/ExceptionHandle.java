package com.expeditors.validations.medicalfacility.shared.exception.handler;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ProblemDetail;

public interface ExceptionHandle<T extends Exception> {

    ProblemDetail handleException(T exception);
}