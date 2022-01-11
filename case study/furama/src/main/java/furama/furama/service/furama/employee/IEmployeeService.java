package furama.furama.service.furama.employee;

import furama.furama.dto.employee.EmployeeDTO;
import furama.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee Employee);

    Employee findById(Integer id);

    void deleteById(Integer id);

    Page<Employee> findAllPage(Pageable of);

    List<Employee> findByName(String name);

    void saveEmployeeDTO(EmployeeDTO employeeDTO);

    Page<Employee> findByNamePage(String nameNew, Pageable pageable);
}
