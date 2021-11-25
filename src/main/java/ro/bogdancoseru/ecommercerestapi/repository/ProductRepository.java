package ro.bogdancoseru.ecommercerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.bogdancoseru.ecommercerestapi.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
