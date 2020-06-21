package com.codegym.furama.model.admin.validateStaff;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = accountExistAnnotationValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface accountExistAnnotation {
    public String message() default "Tên tài khoản này đã được đăng ký";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
