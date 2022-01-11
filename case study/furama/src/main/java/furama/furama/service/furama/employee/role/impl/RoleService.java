package furama.furama.service.furama.employee.role.impl;

import furama.furama.model.employee.AppRole;
import furama.furama.repository.employee.IRoleRepository;
import furama.furama.service.furama.employee.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;


    @Override
    public List<AppRole> findAll() {
        return iRoleRepository.findAll();
    }
}
