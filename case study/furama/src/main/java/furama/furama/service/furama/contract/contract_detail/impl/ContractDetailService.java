package furama.furama.service.furama.contract.contract_detail.impl;

import furama.furama.model.contract.ContractDetail;
import furama.furama.repository.contract.IContractDetailRepository;
import furama.furama.service.furama.contract.contract_detail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository iContractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        iContractDetailRepository.delete(contractDetail);
    }
}
