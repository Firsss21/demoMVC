package com.example.demomvc.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PrefixConstaintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Prefix {
    // define default prefix code
    public String value() default "TEST";
    // define default error message
    public String message() default "must start with TEST";
    // define default groups
    public Class<?>[] groups() default {};
    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
