package shopcontrol.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shopcontrol.inventory.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findBySku(@Param("sku") String sku);

    Optional<Product> findByName(String name);

    Optional<Product> findByEan(String ean);
}
