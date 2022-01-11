package furama.furama.model.serviceResort;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RentTypeId;

    private String RentTypeName;
    private Double RentTypeCost;


    @OneToMany(mappedBy = "rentType", cascade = CascadeType.REMOVE)
    private Set<ServiceResort> serviceResort;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return RentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        RentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return RentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        RentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return RentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        RentTypeCost = rentTypeCost;
    }

    public Set<ServiceResort> getServiceResort() {
        return serviceResort;
    }

    public void setServiceResort(Set<ServiceResort> serviceResort) {
        this.serviceResort = serviceResort;
    }
}
