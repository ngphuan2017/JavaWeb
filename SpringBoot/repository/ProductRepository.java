package JavaWeb.SpringBoot.repository;

import JavaWeb.SpringBoot.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
