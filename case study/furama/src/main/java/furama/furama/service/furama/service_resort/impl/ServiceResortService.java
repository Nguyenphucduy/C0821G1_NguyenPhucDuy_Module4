package furama.furama.service.furama.service_resort.impl;

import furama.furama.dto.service_resort.ServiceResortDTO;
import furama.furama.model.serviceResort.ServiceResort;
import furama.furama.repository.service_resort.IServiceResortRepository;
import furama.furama.service.furama.service_resort.IServiceResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceResortService implements IServiceResortService {
    @Autowired
    IServiceResortRepository iServiceResortRepository;

    @Override
    public List<ServiceResort> findAll() {
        return iServiceResortRepository.findAll();
    }

    @Override
    public void save(ServiceResort serviceResort) {
        iServiceResortRepository.save(serviceResort);

    }

    @Override
    public ServiceResort findById(Integer id) {
        return iServiceResortRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iServiceResortRepository.deleteById(id);

    }

    @Override
    public Page<ServiceResort> findAllPage(Pageable of) {
        return iServiceResortRepository.findAll(of);
    }

    @Override
    public List<ServiceResort> findByName(String name) {
        return iServiceResortRepository.findByName(name);
    }

    @Override
    public void saveServiceResortDTO(ServiceResortDTO serviceResortDTO) {
        ServiceResort serviceResort = new ServiceResort(serviceResortDTO.getCodeServiceResort(),serviceResortDTO.getUsableArea(),serviceResortDTO.getNumberOfPeople(),serviceResortDTO.getStandardRoom(),serviceResortDTO.getDescriptionOtherConvenience(),serviceResortDTO.getPoolArea(),serviceResortDTO.getNumberOfFloors(),serviceResortDTO.getServiceType(),serviceResortDTO.getRentType());
        iServiceResortRepository.save(serviceResort);
    }

    @Override
    public Page<ServiceResort> findByNamePage(String nameNew, Pageable pageable) {
        return iServiceResortRepository.findByNamePage(nameNew,pageable);
    }
}
