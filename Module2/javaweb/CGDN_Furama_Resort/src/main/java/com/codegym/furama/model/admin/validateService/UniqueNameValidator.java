package com.codegym.furama.model.admin.validateService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.codegym.furama.model.admin.ServiceModel.Service;
import com.codegym.furama.service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
    @Autowired
    private ServiceService serviceService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            for (Service s : serviceService.findAllService()) {
                if (s.name.equals(value)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}