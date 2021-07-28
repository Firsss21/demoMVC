package com.example.demomvc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrefixConstaintValidator implements ConstraintValidator<Prefix, String> {

    private String prefix;

    public void initialize(Prefix constraint) {
        prefix = constraint.value();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        boolean result = obj.startsWith(prefix);
        return result;
    }
}
