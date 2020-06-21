package com.example.demo.model;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EqualFieldsValidator implements ConstraintValidator<EqualFields, AccountUser> {
    @Override
    public boolean isValid(AccountUser form, ConstraintValidatorContext context) {
        return form.getPass().equals(form.getCheckpass());
    }
}
