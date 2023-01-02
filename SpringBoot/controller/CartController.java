package JavaWeb.SpringBoot.controller;


import JavaWeb.SpringBoot.dto.request.CreatedCartDTO;
import JavaWeb.SpringBoot.entity.Cart;
import JavaWeb.SpringBoot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping
    public ResponseEntity<?> getAllCart(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size,
                                     @RequestParam(value = "sort", required = false) String sort){
        List<Cart> cartList = this.cartService.getAllCart();
        return new ResponseEntity(cartList, HttpStatus.OK);
    }
//    @GetMapping(value = "/{cart-id}")
//    public ResponseEntity getCartById(@PathVariable(value = "cart-id")int cartId){
//        CreatedCartDTO cart2 = new CreatedCartDTO(2, 1, new Date(), new Date(), "1");
//        StringBuilder response = new StringBuilder("Get User By ID: "+cartId);
//        response.append(cart2);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity insertCart(@RequestBody CreatedCartDTO createdCartDTO){
        Cart cart = this.cartService.createdCart(createdCartDTO);
        return new ResponseEntity(cart, HttpStatus.OK);
    }
//    @PutMapping(value = "/{cart-id}")
//    public ResponseEntity updateCart(@PathVariable(value = "cart-id")int cartId,
//                                     @RequestBody UpdateCartDTO updateCartDTO){
//        int productId = updateCartDTO.getProductId();
//        Date createdDate = updateCartDTO.getCreatedDate();
//        Date modifiedDate = updateCartDTO.getModifiedDate();
//        String status = updateCartDTO.getCartStatus();
//        StringBuilder response = new StringBuilder();
//        response.append(cartId).append(productId).append(createdDate)
//                .append(modifiedDate).append(status);
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/{cart-id}")
//    public ResponseEntity deleteCart(@PathVariable(value = "cart-id")int cartId){
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
