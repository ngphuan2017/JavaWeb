package r2s.SpringBoot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.SpringBoot.dto.request.CreatedUserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {
//    @GetMapping(value = "/{user-id}")
//    public ResponseEntity getUserById(@RequestParam(value = "page", required = false) Integer page,
//                                     @RequestParam(value = "size", required = false) Integer size,
//                                     @RequestParam(value = "sort", required = false) String sort){
//        PageResponseDTO pageResponseDTO = new PageResponseDTO();
//        pageResponseDTO.setPage(page);
//        pageResponseDTO.setSize(size);
//        pageResponseDTO.setSort(sort);
//        return new ResponseEntity(pageResponseDTO, HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity getAllUser(){
        CreatedUserDTO user1 = new CreatedUserDTO(1, "A", "0123456789");
        CreatedUserDTO user2 = new CreatedUserDTO(2, "A", "0123456789");
        CreatedUserDTO user3 = new CreatedUserDTO(3, "A", "0123456789");
        StringBuilder response = new StringBuilder("Get All User: ");
        response.append(user1).append(user2).append(user3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertUser(@RequestBody CreatedUserDTO createdUserDTO){
        int userId = createdUserDTO.getUserId();
        String username = createdUserDTO.getUsername();
        String phone = createdUserDTO.getPhone();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(userId).append(username).append(phone).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
