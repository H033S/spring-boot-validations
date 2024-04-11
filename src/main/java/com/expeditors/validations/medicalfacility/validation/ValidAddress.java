package com.expeditors.validations.medicalfacility.validation;


import com.expeditors.validations.medicalfacility.model.formats.StateFormat;
import com.expeditors.validations.medicalfacility.validator.AddressValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AddressValidator.class})
public @interface ValidAddress {

    String message() default  "Invalid or Null Address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    StateFormat value();
}
