package furama.furama.model.person;
import javax.persistence.*;
//Hibernate Inheritance Mapping để tìm hiểu thêm
@MappedSuperclass
public abstract class Person {
    private  String name;
    private  String dateOfBirth;
    private  String gender;
    private  String cardId;
    private  String phoneNumber;
    private  String email;
    private String address;

    public Person() {
    }

    public Person(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cardId = cardId;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
