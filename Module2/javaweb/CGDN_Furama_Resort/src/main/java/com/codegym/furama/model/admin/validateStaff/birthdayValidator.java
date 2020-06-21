package com.codegym.furama.model.admin.validateStaff;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class birthdayValidator implements ConstraintValidator<birthdayAnnotation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null) {
            if (!value.equals("")) {
                if (value.charAt(4)=='-'&&value.charAt(7)=='-'){
                    String[] birthday = value.split("-");
                    int day = Integer.parseInt(birthday[2]);
                    int month = Integer.parseInt(birthday[1]);
                    int year = Integer.parseInt(birthday[0]);
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
                        if (year > 1900) {
                            if (month == 2) {
                                if (day > 0 && day < 30) {
                                    return true;
                                }
                            }
                            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                                if (day > 0 && day < 32) {
                                    return true;
                                }
                            }
                            if (month == 4 || month == 6 || month == 9 || month == 11) {
                                if (day > 0 && day < 31) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        if (year > 1900) {
                            if (month == 2) {
                                if (day > 0 && day < 29) {
                                    return true;
                                }
                            }
                            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                                if (day > 0 && day < 32) {
                                    return true;
                                }
                            }
                            if (month == 4 || month == 6 || month == 9 || month == 11) {
                                if (day > 0 && day < 31) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
