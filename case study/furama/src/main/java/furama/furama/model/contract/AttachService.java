package furama.furama.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AttachServiceId;
    private String attachServiceCode;
    private String attachServiceName;
    private String attachServiceUnit;
    private Double attachServiceCost;
    private Integer attachServiceQuantity;
    private String attachServiceStatus;
    @OneToMany(mappedBy = "attachService", cascade = CascadeType.REMOVE)
    private Set<ContractDetail> contractDetailSet;

    public AttachService() {
    }

    public Integer getAttachServiceId() {
        return AttachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        AttachServiceId = attachServiceId;
    }

    public String getAttachServiceCode() {
        return attachServiceCode;
    }

    public void setAttachServiceCode(String attachServiceCode) {
        this.attachServiceCode = attachServiceCode;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceQuantity() {
        return attachServiceQuantity;
    }

    public void setAttachServiceQuantity(Integer attachServiceQuantity) {
        this.attachServiceQuantity = attachServiceQuantity;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
