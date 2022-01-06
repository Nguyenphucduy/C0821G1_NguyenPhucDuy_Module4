package furama.furama.service.furama.customer;

import furama.furama.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);

    void deleteById(Integer id);
}
