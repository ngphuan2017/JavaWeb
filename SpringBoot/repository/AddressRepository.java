package JavaWeb.SpringBoot.repository;

import JavaWeb.SpringBoot.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
