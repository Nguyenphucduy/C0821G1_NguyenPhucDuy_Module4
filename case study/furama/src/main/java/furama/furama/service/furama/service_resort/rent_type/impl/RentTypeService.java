package furama.furama.service.furama.service_resort.rent_type.impl;

import furama.furama.model.serviceResort.RentType;
import furama.furama.repository.service_resort.IRentTypeRepository;
import furama.furama.service.furama.service_resort.rent_type.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
