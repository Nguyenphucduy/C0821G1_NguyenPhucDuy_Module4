package furama.furama.repository.contract;

import furama.furama.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService,Integer> {


//    select attach_service.attach_service_id,attach_service.attach_service_code,attach_service.attach_service_cost,attach_service.attach_service_name,
//    attach_service.attach_service_quantity,attach_service.attach_service_status,attach_service.attach_service_status
//    from contract
//    join customer on contract.customer_customer_id = customer.customer_id
//    join contract_detail on contract.contract_id= contract_detail.contract_contract_id
//    join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id;

    @Query(value = " select attach_service.attach_service_id,attach_service.attach_service_code,attach_service.attach_service_cost,attach_service.attach_service_name,\n" +
            "    attach_service.attach_service_quantity,attach_service.attach_service_status,attach_service.attach_service_status,attach_service.attach_service_unit\n" +
            "    from contract\n" +
            "    join customer on contract.customer_customer_id = customer.customer_id\n" +
            "    join contract_detail on contract.contract_id= contract_detail.contract_contract_id\n" +
            "    join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id;", nativeQuery = true)
    List<AttachService> findAttachService();
}
