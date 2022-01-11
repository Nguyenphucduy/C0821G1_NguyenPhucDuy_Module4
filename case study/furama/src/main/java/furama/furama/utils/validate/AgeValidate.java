package furama.furama.utils.validate;

import furama.furama.service.furama.customer.ICustomerService;
import furama.furama.utils.AgeConstraint;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidate implements ConstraintValidator<AgeConstraint,String> {
    @Autowired
    ICustomerService iCustomerService;

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String dateOfBirth, ConstraintValidatorContext context) {

        String today = String.valueOf(java.time.LocalDate.now());

        String[] string1 = dateOfBirth.split("-");
        String[] string2 = today.split("-");
        String year1 = string1[0];
        String year2 = string2[0];
        String month1 = string1[1];
        String month2 = string2[1];
        String day1 = string1[2];
        String day2 = string2[2];
        int result1 = Integer.parseInt(year2) - Integer.parseInt(year1);
        int result2 = Integer.parseInt(month2) - Integer.parseInt(month1);
        int result3 = Integer.parseInt(day2) - Integer.parseInt(day1);
        return result1 >= 18 && result2 >= 0 && result3 >= 0;
    }
}
