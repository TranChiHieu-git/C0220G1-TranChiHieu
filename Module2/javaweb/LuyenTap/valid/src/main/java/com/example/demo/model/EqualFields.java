package com.example.demo.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EqualFieldsValidator.class)
@Documented
public @interface EqualFields {
    String message() default "mật khẩu và comfirm mật khẩu phải trùng nhau";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
