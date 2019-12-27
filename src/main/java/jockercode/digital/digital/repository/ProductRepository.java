package jockercode.digital.digital.repository;

import jockercode.digital.digital.pojo.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
