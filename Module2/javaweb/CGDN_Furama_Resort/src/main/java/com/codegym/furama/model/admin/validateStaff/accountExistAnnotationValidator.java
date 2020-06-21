package com.codegym.furama.model.admin.validateStaff;

import com.codegym.furama.model.admin.StaffModel.Staff;
import com.codegym.furama.service.Staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class accountExistAnnotationValidator implements ConstraintValidator<accountExistAnnotation, String> {
    @Autowired
    StaffService staffService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            for (Staff s : staffService.findAllStaff()) {
                if (s.account.equals(value)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
