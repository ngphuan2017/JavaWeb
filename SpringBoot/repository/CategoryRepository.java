package JavaWeb.SpringBoot.repository;

import JavaWeb.SpringBoot.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
