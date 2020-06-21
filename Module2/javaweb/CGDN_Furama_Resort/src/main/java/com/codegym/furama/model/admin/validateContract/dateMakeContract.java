package com.codegym.furama.model.admin.validateContract;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

@Component
public class dateMakeContract implements ConstraintValidator<dateMakeContractValidate, validateContract> {
    @Override
    public boolean isValid(validateContract form, ConstraintValidatorContext context) {
        if (!form.contractDate.equals("")) {
            String[] contractdate = form.contractDate.split("-");
            String[] endcontractdate = form.endContractDate.split("-");
            int day = Integer.parseInt(contractdate[2]);
            int month = Integer.parseInt(contractdate[1]);
            int year = Integer.parseInt(contractdate[0]);
            int day2 = Integer.parseInt(endcontractdate[2]);
            int month2 = Integer.parseInt(endcontractdate[1]);
            int year2 = Integer.parseInt(endcontractdate[0]);
            Date date1 = new Date(year, month, day);
            Date date2 = new Date(year2, month2, day2);
            int time = ((int) (date2.getTime() - date1.getTime())) / 86400000;
            if (time >= 0) {
                return true;
            }
            return false;
        }
        return false;
    }
}
