package com.codegym.furama.model.admin.validateStaff;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class salaryValidator implements ConstraintValidator<salaryAnnotation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            if (!value.equals("")) {
                int salary = Integer.parseInt(value);
                if (salary > 0 && value.charAt(0) != '0') {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
