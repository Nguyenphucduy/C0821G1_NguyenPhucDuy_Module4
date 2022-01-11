package furama.furama.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ContractDetailId;

    @ManyToOne
    @JoinColumn()
    private Contract contract;
    @ManyToOne
    @JoinColumn()
    private AttachService attachService;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return ContractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        ContractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
