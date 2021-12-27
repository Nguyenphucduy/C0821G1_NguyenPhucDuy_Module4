package form.registrationform.common;

import form.registrationform.common.validate.EmailValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidate.class)
//Tạo annotation cho thuộc tính -> Field
//Tạo annotation cho class -> type
//Tạo annotation cho phương thức -> method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default "email đã tồn tại";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}