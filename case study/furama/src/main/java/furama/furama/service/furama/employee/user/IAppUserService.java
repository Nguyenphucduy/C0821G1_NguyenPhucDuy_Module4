package furama.furama.service.furama.employee.user;

import furama.furama.model.employee.AppUser;

import java.util.List;

public interface IAppUserService {
    List<AppUser> findAll();

    void save(AppUser user);
}
