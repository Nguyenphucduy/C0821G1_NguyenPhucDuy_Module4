package furama.furama.service.furama.employee.division.impl;

import furama.furama.model.employee.Division;
import furama.furama.repository.employee.IDivisionRepository;
import furama.furama.service.furama.employee.division.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
