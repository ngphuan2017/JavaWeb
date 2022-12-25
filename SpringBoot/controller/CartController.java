package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedCartDTO;
import JavaWeb.SpringBoot.dto.request.CreatedUserDTO;
import JavaWeb.SpringBoot.dto.request.UpdateCartDTO;
import JavaWeb.SpringBoot.dto.request.UpdateUserDTO;
import JavaWeb.SpringBoot.dto.response.PageResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @GetMapping(value = "/get-all")
    public ResponseEntity getAllCart(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size,
                                     @RequestParam(value = "sort", required = false) String sort){
        CreatedCartDTO cart1 = new CreatedCartDTO(1, 3, new Date(), new Date(), "0");
        CreatedCartDTO cart2 = new CreatedCartDTO(2, 1, new Date(), new Date(), "1");
        CreatedCartDTO cart3 = new CreatedCartDTO(3, 2, new Date(), new Date(), "2");
        List<CreatedCartDTO> createdCartDTOList = new ArrayList<>();
        createdCartDTOList.add(cart1);
        createdCartDTOList.add(cart2);
        createdCartDTOList.add(cart3);
        StringBuilder response = new StringBuilder("Get All Cart: ");
        PageResponseDTO pageResponseDTO = new PageResponseDTO();
        pageResponseDTO.setPage(page);
        pageResponseDTO.setSize(size);
        pageResponseDTO.setSort(sort);
        response.append(createdCartDTOList).append(pageResponseDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping(value = "/{cart-id}")
    public ResponseEntity getCartById(@PathVariable(value = "cart-id")int cartId){
        CreatedCartDTO cart2 = new CreatedCartDTO(2, 1, new Date(), new Date(), "1");
        StringBuilder response = new StringBuilder("Get User By ID: "+cartId);
        response.append(cart2);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertCart(@RequestBody CreatedCartDTO createdCartDTO){
        int cartId = createdCartDTO.getCartId();
        int productId = createdCartDTO.getProductId();
        Date createdDate = createdCartDTO.getCreatedDate();
        Date modifiedDate = createdCartDTO.getModifiedDate();
        String status = createdCartDTO.getCartStatus();
        StringBuilder response = new StringBuilder();
        response.append(cartId).append(productId).append(createdDate)
                .append(modifiedDate).append(status);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping(value = "/{cart-id}")
    public ResponseEntity updateCart(@PathVariable(value = "cart-id")int cartId,
                                     @RequestBody UpdateCartDTO updateCartDTO){
        int productId = updateCartDTO.getProductId();
        Date createdDate = updateCartDTO.getCreatedDate();
        Date modifiedDate = updateCartDTO.getModifiedDate();
        String status = updateCartDTO.getCartStatus();
        StringBuilder response = new StringBuilder();
        response.append(cartId).append(productId).append(createdDate)
                .append(modifiedDate).append(status);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{cart-id}")
    public ResponseEntity deleteCart(@PathVariable(value = "cart-id")int cartId){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
