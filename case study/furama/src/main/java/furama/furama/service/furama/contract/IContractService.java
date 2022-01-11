package furama.furama.service.furama.contract;


import furama.furama.dto.contract.ContractDTO;
import furama.furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Contract findById(Integer id);

    void deleteById(Integer id);
    Page<Contract> findAllPage(Pageable of);

    void saveContractDTO(ContractDTO contractDTO);

//    List<Contract> findByStartDate(String name);

}
