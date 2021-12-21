package cg.wbd.grandemonstration.model;
import javax.persistence.*;

@Entity(name = "customer")
//@Table
public class Customer implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
//    @Column(name = "customer_id" , columnDefinition = "int")
    private Long id;
    @Column(name = "customer_name" )
//    @Column(name = "customer_name" , columnDefinition = "VACHAR(255)")
    private String name;
    @Column(name = "customer_email" )
//    @Column(name = "customer_email" , columnDefinition = "VACHAR(255)")
    private String email;
    @Column(name = "customer_address" )
//    @Column(name = "customer_address" , columnDefinition = "VACHAR(255)")
    private String address;

    public Customer() {
    }

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public Customer clone() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
