package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.dto.request.UpdateAddressDTO;
import JavaWeb.SpringBoot.dto.request.UpdateUserDTO;
import JavaWeb.SpringBoot.dto.response.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping(value = "/{get-all}")
    public ResponseEntity getAllUser(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size,
                                     @RequestParam(value = "sort", required = false) String sort){
        CreatedUserDTO user1 = new CreatedUserDTO(1, "A", "0123456789");
        CreatedUserDTO user2 = new CreatedUserDTO(2, "A", "0123456789");
        CreatedUserDTO user3 = new CreatedUserDTO(3, "A", "0123456789");
        StringBuilder response = new StringBuilder("Get All User: ");
        List<CreatedUserDTO> createdUserDTOList = new ArrayList<>();
        createdUserDTOList.add(user1);
        createdUserDTOList.add(user2);
        createdUserDTOList.add(user3);
        PageResponseDTO pageResponseDTO = new PageResponseDTO();
        pageResponseDTO.setPage(page);
        pageResponseDTO.setSize(size);
        pageResponseDTO.setSort(sort);
        response.append(createdUserDTOList).append(pageResponseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping(value = "/{user-id}")
    public ResponseEntity getUserById(@PathVariable(value = "user-id")int userId){
        CreatedUserDTO user1 = new CreatedUserDTO(1, "A", "0123456789");
        StringBuilder response = new StringBuilder("Get User By ID: "+userId);
        response.append(user1);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertUser(@RequestBody CreatedUserDTO createdUserDTO){
        int userId = createdUserDTO.getUserId();
        String username = createdUserDTO.getUsername();
        String phone = createdUserDTO.getPhone();
        StringBuilder response = new StringBuilder();
        response.append(userId).append(username).append(phone).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping(value = "/{user-id}")
    public ResponseEntity updateUser(@PathVariable(value = "user-id")int userId,
                                        @RequestBody UpdateUserDTO updateUserDTO){
        String username = updateUserDTO.getUsername();
        String phone =updateUserDTO.getPhone();
        StringBuilder response = new StringBuilder();
        response.append(userId).append(username).append(phone);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{user-id}")
    public ResponseEntity deleteUser(@PathVariable(value = "user-id")int userId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
