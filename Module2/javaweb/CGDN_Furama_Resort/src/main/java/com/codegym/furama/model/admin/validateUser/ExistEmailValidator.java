package com.codegym.furama.model.admin.validateUser;

import com.codegym.furama.model.admin.UserModel.User;
import com.codegym.furama.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ExistEmailValidator implements ConstraintValidator<ExistEmail, String> {
    @Autowired
    UserService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            for (User s : userService.findAllUser()) {
                if (s.getEmail().equals(value)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
