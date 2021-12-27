package form.registrationform.dto;

import form.registrationform.common.EmailConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
public class UserDTO implements Validator {
    @Size(min=5, max=45 , message = "First name or last name phải có tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String firstName, lastName;


    private @Pattern(regexp = "^[0-9]{9,12}$", message = "Số điện thoại phải từ 9- > 12")
    String phoneNumber;


    private String age;


    @Pattern(regexp="(^\\w+@\\w+(\\.\\w+){1,2}$)",message = "Lỗi định dạng email")
    @EmailConstraint
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, @Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public @Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target; //Ép kiểu ngầm định
        String age = userDTO.age;
        String today = String.valueOf(java.time.LocalDate.now());

        String[] string1 = age.split("-");
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
        if(!(result1>=18&&result2>=0&&result3>=0)) {
            errors.rejectValue("age", "age.invalidFormat");
        }
    }
}
