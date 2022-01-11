package furama.furama.utils;



import furama.furama.utils.validate.CodeValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CodeValidate.class)
//Tạo annotation cho thuộc tính -> Field
//Tạo annotation cho class -> type
//Tạo annotation cho phương thức -> method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodeConstraint {
    String message() default "Mã này đã tồn tại, mời nhập mã khác";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}