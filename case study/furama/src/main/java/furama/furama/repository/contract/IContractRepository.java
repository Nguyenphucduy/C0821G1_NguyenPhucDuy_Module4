package furama.furama.repository.contract;

import furama.furama.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
//    @Query(value = "select * from contract where contract_code like :contractCode",nativeQuery = true)
//    List<Contract> findByStarDate(@Param("contractCode") String contractCode);

    //    select contract.contract_id,contract.contract_code,contract.contract_deposit,contract.contract_end_date,contract.contract_start_date,
//    contract.contract_total_money,contract.customer_customer_id,contract.employee_employee_id,contract.service_resort_service_resort_id
//    from contract
//    join customer on contract.customer_customer_id = customer.customer_id
//    join contract_detail on contract.contract_id= contract_detail.contract_contract_id
//    join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id;

}
