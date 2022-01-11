package furama.furama.service.furama.employee.education_degree.impl;

import furama.furama.model.employee.EducationDegree;
import furama.furama.repository.employee.IEducationDegreeRepository;
import furama.furama.service.furama.employee.education_degree.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
