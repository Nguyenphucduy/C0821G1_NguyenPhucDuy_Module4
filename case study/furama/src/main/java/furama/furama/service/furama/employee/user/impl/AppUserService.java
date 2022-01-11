package furama.furama.service.furama.employee.user.impl;

import furama.furama.model.employee.AppUser;
import furama.furama.repository.employee.AppUserRepository;
import furama.furama.service.furama.employee.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserService implements IAppUserService {
    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public void save(AppUser user) {
        appUserRepository.save(user);
    }
}
