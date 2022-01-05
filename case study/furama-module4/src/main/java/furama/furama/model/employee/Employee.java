package furama.furama.model.employee;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeDateOfBirth;
    private String employeeGender;
    private String employeeCardId;
    private String employeePhoneNumber;
    private String employeeEmail;
    private String employeeAddress;
    private Double employeeSalary;


    private Integer position;
    private Integer educationDegree;
    private Integer division;
    private String userName;

    public Employee() {

    }



}
