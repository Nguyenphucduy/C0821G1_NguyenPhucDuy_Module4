package furama.furama.model.customer;

import furama.furama.model.contract.Contract;
import furama.furama.model.person.Person;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerCode;

    @ManyToOne
    @JoinColumn()
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Contract> contracts;

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer() {
    }



    public Customer(Integer customerId, String customerCode) {
        this.customerId = customerId;
        this.customerCode = customerCode;
    }

    public Customer(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address, String customerCode, CustomerType customerType) {
        super(name, dateOfBirth, gender, cardId, phoneNumber, email, address);
        this.customerCode = customerCode;
        this.customerType = customerType;
    }

    public Customer(String name, String dateOfBirth, String gender, String cardId, String phoneNumber, String email, String address, Integer customerId, String customerCode, CustomerType customerType) {
        super(name, dateOfBirth, gender, cardId, phoneNumber, email, address);
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerType = customerType;
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
