package JavaWeb.SpringBoot.repository;

import JavaWeb.SpringBoot.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
