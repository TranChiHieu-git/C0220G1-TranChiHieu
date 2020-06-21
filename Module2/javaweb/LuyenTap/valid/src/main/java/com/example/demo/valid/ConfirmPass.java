package com.example.demo.valid;

import com.example.demo.model.AccountUser;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ConfirmPass implements ConstraintValidator<PassCheck, String> {
    String pass;

    @Override
    public void initialize(PassCheck constraintAnnotation) {
        pass = constraintAnnotation.pass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals(pass);
    }
}
