package JavaWeb.SpringBoot.repository;

import JavaWeb.SpringBoot.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
