package JavaWeb.SpringBoot.repository;

import JavaWeb.SpringBoot.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
