package furama.furama.model.employee;


import furama.furama.model.contract.Contract;
import furama.furama.model.person.Person;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeCode;
    private Double employeeSalary;

    @ManyToOne
    @JoinColumn()
    private Position position;

    @ManyToOne
    @JoinColumn()
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn()
    private Division division;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToOne
    @JoinColumn()
    private AppUser appUser;



    public Employee() {

    }

    public Employee(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address, String employeeCode, Double employeeSalary, Position position, EducationDegree educationDegree, Division division, AppUser appUser) {
        super(name, dateOfBirth, gender, cardId, phoneNumber, email, address);
        this.employeeCode = employeeCode;
        this.employeeSalary = employeeSalary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.appUser = appUser;
    }

    public Employee(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address, Integer employeeId, String employeeCode, Double employeeSalary, Position position, EducationDegree educationDegree, Division division, AppUser appUser) {
        super(name, dateOfBirth, gender, cardId, phoneNumber, email, address);
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeSalary = employeeSalary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
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
