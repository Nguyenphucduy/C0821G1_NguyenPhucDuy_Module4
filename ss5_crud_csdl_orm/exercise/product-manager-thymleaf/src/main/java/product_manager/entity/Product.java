package product_manager.entity;
import javax.persistence.*;
@Entity(name = "product")
public class Product implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", columnDefinition = "INT")
    private Integer id;
//    @Column(name = "name" ,columnDefinition = "VARCHAR(255)")
    private String name;
//    @Column(name = "price",columnDefinition = "DOUBLE")
    private Double price;
//    @Column(name = "manufacture",columnDefinition = "VARCHAR(255)")
    private String manufacture;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

}
