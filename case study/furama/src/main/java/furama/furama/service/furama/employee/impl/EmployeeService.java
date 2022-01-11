package furama.furama.service.furama.employee.impl;

import furama.furama.dto.employee.EmployeeDTO;
import furama.furama.model.employee.AppRole;
import furama.furama.model.employee.AppUser;
import furama.furama.model.employee.Employee;
import furama.furama.model.employee.UserRole;
import furama.furama.repository.employee.AppUserRepository;
import furama.furama.repository.employee.IEmployeeRepository;
import furama.furama.repository.employee.IRoleRepository;
import furama.furama.repository.employee.UserRoleRepository;
import furama.furama.service.furama.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    IRoleRepository iRoleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);

    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iEmployeeRepository.deleteById(id);

    }

    @Override
    public Page<Employee> findAllPage(Pageable of) {
        return iEmployeeRepository.findAll(of);
    }

    @Override
    public List<Employee> findByName(String name) {
        return iEmployeeRepository.findByName(name);
    }

    @Override
    public void saveEmployeeDTO(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(),employeeDTO.getDateOfBirth(),employeeDTO.getGender(),employeeDTO.getCardId(),employeeDTO.getPhoneNumber(),employeeDTO.getEmail(),employeeDTO.getAddress(),employeeDTO.getEmployeeCode(),employeeDTO.getEmployeeSalary(),employeeDTO.getPosition(),employeeDTO.getEducationDegree(),employeeDTO.getDivision(),employeeDTO.getAppUser());

        AppUser appUser = new AppUser();
        appUser.setUserName(employee.getAppUser().getUserName());
        appUser.setEnabled("0");
        appUser.setEncrytedPassword("$2a$12$X2xz.FXnKzN3jw0n0xQuhuckm3hlW8jLImiOqVPOVWmtTTQSZhH3q");
        appUserRepository.save(appUser);

        // phân quyền

        UserRole userRole = new UserRole();


        AppRole appRole1 = null;
        for (AppRole appRole :iRoleRepository.findAll()){
            if (appRole.getRoleId()==2){// Role_User
                appRole1 = appRole;
            }
        }

        userRole.setAppRole(appRole1);
        userRole.setAppUser(appUser);
        userRoleRepository.save(userRole);

        employee.setAppUser(appUser);

        iEmployeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findByNamePage(String nameNew, Pageable pageable) {
        return iEmployeeRepository.findByNamePage(nameNew,pageable);
    }
}
