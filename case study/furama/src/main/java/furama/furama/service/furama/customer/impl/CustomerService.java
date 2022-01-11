package furama.furama.service.furama.customer.impl;

import furama.furama.dto.customer.CustomerDTO;
import furama.furama.model.customer.Customer;
import furama.furama.repository.customer.ICustomerRepository;
import furama.furama.service.furama.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public void saveCustomerDTO(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName(),customerDTO.getDateOfBirth(),customerDTO.getGender(),customerDTO.getCardId(),customerDTO.getPhoneNumber(),customerDTO.getEmail(),customerDTO.getAddress(),customerDTO.getCustomerCode(),customerDTO.getCustomerType());
        iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findCustomerUsingService() {
        return iCustomerRepository.findCustomerUsingService();
    }

    @Override
    public Page<Customer> findByNamePage(String nameNew,Pageable of) {
        return iCustomerRepository.findByNamePage(nameNew,of);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getName(),customerDTO.getDateOfBirth(),customerDTO.getGender(),customerDTO.getCardId(),customerDTO.getPhoneNumber(),customerDTO.getEmail(),customerDTO.getAddress(),customerDTO.getCustomerId(),customerDTO.getCustomerCode(),customerDTO.getCustomerType());
        iCustomerRepository.save(customer);
    }
}
