package furama.furama.repository.customer;

import furama.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


//    @Query(value = "select * from customer where name like :name",nativeQuery = true)
//    Page<Customer> findByNamePage(@Param("name")String nameNew, PageRequest of);
}
