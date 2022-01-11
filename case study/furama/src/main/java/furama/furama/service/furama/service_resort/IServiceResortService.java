package furama.furama.service.furama.service_resort;

import furama.furama.dto.service_resort.ServiceResortDTO;
import furama.furama.model.serviceResort.ServiceResort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceResortService {
    List<ServiceResort> findAll();

    void save(ServiceResort serviceResort);

    ServiceResort findById(Integer id);

    void deleteById(Integer id);

    Page<ServiceResort> findAllPage(Pageable of);

    List<ServiceResort> findByName(String name);

    void saveServiceResortDTO(ServiceResortDTO serviceResortDTO);

    Page<ServiceResort> findByNamePage(String nameNew, Pageable pageable);

    void updateServiceResortDTO(ServiceResortDTO serviceResortDTO);
}
