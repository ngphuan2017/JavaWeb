package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.entity.User;
import JavaWeb.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        Iterable<User> userIterable = this.userRepository.findAll();
        return (List)userIterable;
    }
    @Override
    public User createdUser(CreatedUserDTO createdUserDTO) {
        User user = new User();
        user.setUsername(createdUserDTO.getUsername());
        user.setPassword(createdUserDTO.getPassword());
        user.setPhone(createdUserDTO.getPhone());
        user.setGender(createdUserDTO.getGender());
        user.setEmail(createdUserDTO.getEmail());
        user.setImgLink(createdUserDTO.getImgLink());
        this.userRepository.save(user);
        return user;
    }
}
