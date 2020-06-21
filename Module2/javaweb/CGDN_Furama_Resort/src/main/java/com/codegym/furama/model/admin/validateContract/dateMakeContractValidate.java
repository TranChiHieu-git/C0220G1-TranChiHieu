package com.codegym.furama.model.admin.validateContract;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = dateMakeContract.class)
@Documented
public @interface dateMakeContractValidate {
    String message() default "Ngày làm hợp đồng phải nhỏ hơn hoặc bằng ngày kết thúc hợp đồng";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
