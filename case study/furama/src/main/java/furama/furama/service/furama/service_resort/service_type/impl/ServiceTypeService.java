package furama.furama.service.furama.service_resort.service_type.impl;

import furama.furama.model.serviceResort.ServiceType;
import furama.furama.repository.service_resort.IServiceTypeRepository;
import furama.furama.service.furama.service_resort.service_type.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
