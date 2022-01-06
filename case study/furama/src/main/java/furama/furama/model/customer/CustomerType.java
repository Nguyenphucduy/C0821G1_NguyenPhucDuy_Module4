package furama.furama.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTypeId;
    private String customerTypeName;


    @OneToMany(mappedBy = "customerType", cascade = CascadeType.REMOVE)
    private Set<Customer> Customer;

    public CustomerType() {
    }

    public CustomerType(Integer customerTypeId, String customerTypeName, Set<Customer> customer) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        Customer = customer;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<furama.furama.model.customer.Customer> getCustomer() {
        return Customer;
    }

    public void setCustomer(Set<furama.furama.model.customer.Customer> customer) {
        Customer = customer;
    }
}
