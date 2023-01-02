package JavaWeb.SpringBoot.service;

import JavaWeb.SpringBoot.dto.request.CreatedCartDTO;
import JavaWeb.SpringBoot.entity.Cart;
import JavaWeb.SpringBoot.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Override
    public List<Cart> getAllCart() {
        Iterable<Cart> cartIterable = this.cartRepository.findAll();
        return (List)cartIterable;
    }
    @Override
    public Cart createdCart(CreatedCartDTO createdCartDTO) {
        Cart cart = new Cart();
        cart.setPrice(createdCartDTO.getPrice());
        cart.setStatus(createdCartDTO.getStatus());
        this.cartRepository.save(cart);
        return cart;
    }
}
