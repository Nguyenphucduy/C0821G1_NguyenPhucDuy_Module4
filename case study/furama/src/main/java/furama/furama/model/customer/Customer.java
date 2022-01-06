package furama.furama.model.customer;

import furama.furama.model.person.Person;

import javax.persistence.*;

@Entity
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerCode;

    @ManyToOne
    @JoinColumn()
    private CustomerType customerType;


    public Customer() {
    }

    public Customer(Integer customerId, String customerCode, String customerName ) {
        this.customerId = customerId;
        this.customerCode = customerCode;
    }

    public Customer(Integer customerId, String customerCode) {
        this.customerId = customerId;
        this.customerCode = customerCode;
    }

    public Customer(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address, Integer customerId, String customerCode) {
        super(name, dateOfBirth, gender, cardId, phoneNumber, email, address);
        this.customerId = customerId;
        this.customerCode = customerCode;
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


    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
