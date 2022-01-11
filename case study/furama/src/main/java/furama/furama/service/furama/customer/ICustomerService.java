package furama.furama.service.furama.customer;

import furama.furama.dto.customer.CustomerDTO;
import furama.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void deleteById(Integer id);

    Page<Customer> findAll(Pageable of);

    List<Customer> findByName(String name);

    void saveCustomerDTO(CustomerDTO customerDTO);

    List<Customer> findCustomerUsingService();

    Page<Customer> findByNamePage(String nameNew,Pageable of);
}
