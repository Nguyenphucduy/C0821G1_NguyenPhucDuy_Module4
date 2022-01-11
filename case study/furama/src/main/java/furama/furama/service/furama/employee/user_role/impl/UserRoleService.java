package furama.furama.service.furama.employee.user_role.impl;

import furama.furama.model.employee.UserRole;
import furama.furama.repository.employee.UserRoleRepository;
import furama.furama.service.furama.employee.user_role.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    UserRoleRepository UserRoleRepository;
    @Override
    public void save(UserRole userRole) {
        UserRoleRepository.save(userRole);
    }
}
