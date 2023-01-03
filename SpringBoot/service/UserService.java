package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User createdUser(CreatedUserDTO createdUserDTO);
}
