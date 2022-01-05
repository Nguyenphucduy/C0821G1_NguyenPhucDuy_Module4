package furama.furama.service.furama.customer_type.impl;

import furama.furama.repository.customer_type.ICustomerTypeRepository;
import furama.furama.service.furama.customer_type.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerType implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<furama.furama.model.customer.CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
