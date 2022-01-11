package furama.furama.repository.customer;

import furama.furama.model.contract.Contract;
import furama.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    //    nativeQuery = true - > SQL , false -> HQL
    @Query(value = "select * from customer where name like :name",nativeQuery = true)
    List<Customer> findByName(@Param("name") String name);

    @Query(value = " select customer.customer_id,customer.address,customer.card_id,customer.date_of_birth,customer.email,customer.gender,customer.name,customer.phone_number,\n" +
            "customer.customer_code,customer.customer_type_customer_type_id\n" +
            "from contract\n" +
            "join customer on contract.customer_customer_id = customer.customer_id\n" +
            "join contract_detail on contract.contract_id= contract_detail.contract_contract_id\n" +
            "join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id", nativeQuery = true)
    List<Customer> findCustomerUsingService();

    @Query(value = "select * from customer where name like :nameNew",nativeQuery = true)
    Page<Customer> findByNamePage(@Param("nameNew")String nameNew, Pageable of);
}
