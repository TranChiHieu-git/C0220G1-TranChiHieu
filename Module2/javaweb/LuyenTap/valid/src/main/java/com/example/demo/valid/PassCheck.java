package com.example.demo.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = ConfirmPass.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassCheck {
    String message() default "Mật khẩu và giá trị nhập vào không trùng khớp";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    String pass();
}
