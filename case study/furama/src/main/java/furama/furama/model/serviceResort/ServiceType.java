package furama.furama.model.serviceResort;


import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ServiceTypeId;

    private String ServiceTypeName;


    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.REMOVE)
    private Set<ServiceResort> serviceResort;

    public ServiceType() {
    }

    public Integer getServiceTypeId() {
        return ServiceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        ServiceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return ServiceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        ServiceTypeName = serviceTypeName;
    }

    public Set<ServiceResort> getServiceResort() {
        return serviceResort;
    }

    public void setServiceResort(Set<ServiceResort> serviceResort) {
        this.serviceResort = serviceResort;
    }
}
