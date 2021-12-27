package form.registrationform.service.impl;

import form.registrationform.dto.UserDTO;
import form.registrationform.model.User;
import form.registrationform.repository.IUserRepository;
import form.registrationform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public void save(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setCreateDate(String.valueOf(LocalDate.now()));
        iUserRepository.save(user);
    }
}
