package furama.furama.utils;

import furama.furama.utils.validate.AgeValidate;
import furama.furama.utils.validate.CodeValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidate.class)
//Tạo annotation cho thuộc tính -> Field
//Tạo annotation cho class -> type
//Tạo annotation cho phương thức -> method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeConstraint {
    String message() default "Tuổi phải lớn hơn 18";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}