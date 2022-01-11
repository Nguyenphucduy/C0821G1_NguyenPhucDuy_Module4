package furama.furama.service.furama.contract.contract_detail;

import furama.furama.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    List<ContractDetail> findAll();

    void delete(ContractDetail contractDetail);
}
