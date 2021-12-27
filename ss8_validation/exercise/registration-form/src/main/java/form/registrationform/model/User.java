package form.registrationform.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName, lastName;
    private @javax.validation.constraints.Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String phoneNumber;
    private String age;
    private String email;
    private String createDate;



    public User() {
    }

    public User(Integer id, String firstName, String lastName, @javax.validation.constraints.Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String phoneNumber, String age, String email, String createDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.createDate = createDate;
    }

    public User(Integer id, String firstName, String lastName, @javax.validation.constraints.Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public @javax.validation.constraints.Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@javax.validation.constraints.Pattern(regexp = "^[0-9]{9,12}$", message = "@Phone") String phoneNumber) {
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
