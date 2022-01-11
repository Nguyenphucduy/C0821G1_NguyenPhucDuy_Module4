package furama.furama.dto.employee;

import furama.furama.model.employee.AppUser;
import furama.furama.model.employee.Division;
import furama.furama.model.employee.EducationDegree;
import furama.furama.model.employee.Position;
import furama.furama.utils.CodeConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class EmployeeDTO {
    private Integer employeeId;
//    @CodeConstraint()
    @Pattern(regexp = "^NV\\d{4}$", message = "Tên bắt đầu NV  và  phải có 4 số")
    @NotBlank(message = "mã nhân viên không được để trống (NotBlank)")
    private String employeeCode;

    @NotBlank(message = "tên không được để trống (NotBlank)")
    @Pattern(regexp = "^[A-z ]{6,20}$", message = "Tên 6- > 20")
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
    @Pattern(regexp = "^[A-z ]{6,100}$", message = "địa chỉ không được phép quá 100 kí tự")
    private String address;
    @Positive(message = "lương phải lớn hơn 0")
    private Double employeeSalary;
    private String gender;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private AppUser appUser;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public EmployeeDTO() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
