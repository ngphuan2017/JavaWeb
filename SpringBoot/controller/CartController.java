package r2s.SpringBoot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.SpringBoot.dto.request.CreatedCartDTO;

import java.util.Date;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @GetMapping
    public ResponseEntity getAllCart(){
        CreatedCartDTO cart1 = new CreatedCartDTO(1, 3, new Date(), new Date(), "0");
        CreatedCartDTO cart2 = new CreatedCartDTO(2, 1, new Date(), new Date(), "1");
        CreatedCartDTO cart3 = new CreatedCartDTO(3, 2, new Date(), new Date(), "2");
        StringBuilder response = new StringBuilder("Get All Cart: ");
        response.append(cart1).append(cart2).append(cart3);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertCart(@RequestBody CreatedCartDTO createdCartDTO){
        int cartId = createdCartDTO.getCartId();
        int productId = createdCartDTO.getProductId();
        Date createdDate = createdCartDTO.getCreatedDate();
        Date modifiedDate = createdCartDTO.getModifiedDate();
        String status = createdCartDTO.getCartStatus();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(cartId).append(productId).append(createdDate)
                .append(modifiedDate).append(status).toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
