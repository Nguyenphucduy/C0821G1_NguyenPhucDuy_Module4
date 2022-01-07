package com.codegym.demo_c0821g1.dto;

import com.codegym.demo_c0821g1.utils.annotation.NameConstraint;
import com.codegym.demo_c0821g1.model.ClassRoom;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class StudentDTO implements Validator {

    private Integer id;

    @NotNull(message = "Tên không được để trống ( Not null)")
    @NotEmpty(message = "Tên không được để trống ( Not Empty")
    @NotBlank(message = "Tên không được để trống (NotBlank)")
//    @NameConstraint
    private String name;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date phải đúng định dạng yyyy-mm-dd")
    private String dateOfBirth;


    private Integer gender;

    private Double grade;

    private ClassRoom classRoom;

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name,
                   String dateOfBirth, Integer gender, Double grade) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       StudentDTO studentDTO = (StudentDTO) target; //Ép kiểu ngầm định
       if(!studentDTO.name.matches("[A-Za-z ]{4,}")) {
           errors.rejectValue("name", "name.invalidFormat");
       }
    }
}
