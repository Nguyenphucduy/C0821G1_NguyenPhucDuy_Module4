package furama.furama.dto.customer;

import furama.furama.model.customer.CustomerType;
import furama.furama.utils.CodeConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerUpdateDTO implements Validator {
    private Integer customerId;
//    @CodeConstraint
    @Pattern(regexp = "^KH\\d{4}$", message = "Tên bắt đầu KH  và  phải có 4 số")
    @NotBlank(message = "mã khách hàng không được để trống (NotBlank)")
    private String customerCode;

    @NotBlank(message = "tên không được để trống (NotBlank)")
    @Pattern(regexp = "^[A-z ]{6,20}$", message = "Tên 9- > 12")
    private String name;

    @NotBlank(message = " không được để trống (NotBlank)")
    private String dateOfBirth;

    @NotBlank(message = "không được để trống (NotBlank)")
    @Pattern(regexp = "^[0-9]{9,12}$", message = "cardId phải từ 9- > 12")
    private String cardId;

    @NotBlank(message = "không được để trống (NotBlank)")
    @Pattern(regexp = "^(090|091|8490|8491)\\d{7}$", message = "Số điện thoại phải từ 9- > 12 và bắt đầu bằng 090|091|8490|8491")
    private String phoneNumber;

    @NotBlank(message = "không được để trống (NotBlank)")
    @Pattern(regexp="(^\\w+@\\w+(\\.\\w+){1,2}$)",message = "Lỗi định dạng email")
    private String email;

    @NotBlank(message = "không được để trống (NotBlank)")
    @Pattern(regexp = "^[A-z ]{9,100}$", message = "địa chỉ không được phép quá 100 kí tự")
    private String address;

    @NotBlank(message = " không được để trống (NotBlank)")
    private String gender;


    private CustomerType customerType;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CustomerUpdateDTO() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerUpdateDTO customerUpdateDTO = (CustomerUpdateDTO) target; //Ép kiểu ngầm định
        String dateOfBirth = customerUpdateDTO.dateOfBirth;
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
        if(!(result1>=18&&result2>=0&&result3>=0)) {
            errors.rejectValue("dateOfBirth", "age.invalidFormat");
        }
    }
}
