package com.example.demomvc.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUserConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUser {
    // define default error message
    public String message() default "user with this name exists";
    // define default groups
    public Class<?>[] groups() default {};
    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}

