package furama.furama.service.furama.customer.impl;

import furama.furama.model.customer.Customer;
import furama.furama.repository.customer.ICustomerRepository;
import furama.furama.service.furama.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iCustomerRepository.deleteById(id);
    }
    @Override
    public Page<Customer> findAll(Pageable of) {
        return iCustomerRepository.findAll(of);
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.findByName(name);
    }

//    @Override
//    public Page<Customer> findByNamePage(String nameNew, PageRequest of) {
//        return iCustomerRepository.findByNamePage(nameNew);
//    }
}
