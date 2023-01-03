package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.entity.User;
import JavaWeb.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<?> getAllUser(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size,
                                     @RequestParam(value = "sort", required = false) String sort){
        List<User> userList = this.userService.getAllUser();
        return new ResponseEntity(userList, HttpStatus.OK);
    }
//    @GetMapping(value = "/{user-id}")
//    public ResponseEntity getUserById(@PathVariable(value = "user-id")int userId){
//        CreatedUserDTO user1 = new CreatedUserDTO(1, "A", "0123456789");
//        StringBuilder response = new StringBuilder("Get User By ID: "+userId);
//        response.append(user1);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity insertUser(@RequestBody CreatedUserDTO createdUserDTO){
        User user = this.userService.createdUser(createdUserDTO);
        return new ResponseEntity(user, HttpStatus.OK);
    }
//    @PutMapping(value = "/{user-id}")
//    public ResponseEntity updateUser(@PathVariable(value = "user-id")int userId,
//                                        @RequestBody UpdateUserDTO updateUserDTO){
//        String username = updateUserDTO.getUsername();
//        String phone =updateUserDTO.getPhone();
//        StringBuilder response = new StringBuilder();
//        response.append(userId).append(username).append(phone);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/{user-id}")
//    public ResponseEntity deleteUser(@PathVariable(value = "user-id")int userId){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
