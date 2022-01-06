package furama.furama.model.employee;


import furama.furama.model.person.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeCode;
    private Double employeeSalary;
    private Integer position;
    private Integer educationDegree;
    private Integer division;
    private String userName;

    public Employee() {

    }

    public Employee(Integer employeeId, String employeeCode, Double employeeSalary, Integer position, Integer educationDegree, Integer division, String userName) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeSalary = employeeSalary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
    }

    public Employee(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address, Integer employeeId, String employeeCode, Double employeeSalary, Integer position, Integer educationDegree, Integer division, String userName) {
        super(name, dateOfBirth, gender, cardId, phoneNumber, email, address);
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeSalary = employeeSalary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.userName = userName;
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

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(Integer educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
