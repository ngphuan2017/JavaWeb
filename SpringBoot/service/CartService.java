package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedCartDTO;
import JavaWeb.SpringBoot.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCart();

    Cart createdCart(CreatedCartDTO createdCartDTO);
}
