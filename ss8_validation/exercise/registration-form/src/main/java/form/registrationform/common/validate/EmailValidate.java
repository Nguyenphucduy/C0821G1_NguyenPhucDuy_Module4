package form.registrationform.common.validate;

import form.registrationform.common.EmailConstraint;
import form.registrationform.model.User;
import form.registrationform.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidate implements ConstraintValidator<EmailConstraint,String> {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void initialize(EmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        for (User user : iUserRepository.findAll()){
            if (user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
