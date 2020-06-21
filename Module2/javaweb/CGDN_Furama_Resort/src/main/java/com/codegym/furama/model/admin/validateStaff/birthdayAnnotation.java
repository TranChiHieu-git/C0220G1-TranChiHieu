package com.codegym.furama.model.admin.validateStaff;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = birthdayValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface birthdayAnnotation {
    public String message() default "Số ngày trong tháng hoặc số tháng \n trong năm không chính xác";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
