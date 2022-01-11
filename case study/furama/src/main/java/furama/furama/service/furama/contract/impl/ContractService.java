package furama.furama.service.furama.contract.impl;

import furama.furama.dto.contract.ContractDTO;
import furama.furama.model.contract.AttachService;
import furama.furama.model.contract.Contract;
import furama.furama.model.contract.ContractDetail;
import furama.furama.repository.contract.IAttachServiceRepository;
import furama.furama.repository.contract.IContractDetailRepository;
import furama.furama.repository.contract.IContractRepository;
import furama.furama.service.furama.contract.IContractService;
import furama.furama.service.furama.contract.attach_service.IAttachService;
import furama.furama.service.furama.contract.contract_detail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;
    @Autowired
    IAttachServiceRepository iAttachServiceRepository;
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllPage(Pageable of) {
        return iContractRepository.findAll(of);
    }

    @Override
    public void saveContractDTO(ContractDTO contractDTO) {
        Contract contract = new Contract(contractDTO.getContractCode(),contractDTO.getContractStartDate(),contractDTO.getContractEndDate(),contractDTO.getContractDeposit(),contractDTO.getContractTotalMoney(),contractDTO.getEmployee(),contractDTO.getCustomer(),contractDTO.getServiceResort());
        iContractRepository.save(contract);

        ContractDetail contractDetail = new ContractDetail();
        contractDetail.setContract(contract);
        // test trước
        AttachService attachService = null;
        for (AttachService attachService1 : iAttachServiceRepository.findAll()){
            if (attachService1.getAttachServiceId()==1){
                attachService = attachService1;
            }
        }
        contractDetail.setAttachService(attachService);
        iContractDetailRepository.save(contractDetail);
    }

//    @Override
//    public List<Contract> findByStartDate(String starDate) {
//        return iContractRepository.findByStarDate(starDate);
//    }
}
