package com.codegym.demo_c0821g1.common;

import com.codegym.demo_c0821g1.common.validator.NameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
//Tạo annotation cho thuộc tính -> Field
//Tạo annotation cho class -> type
//Tạo annotation cho phương thức -> method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "invalid name";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}
