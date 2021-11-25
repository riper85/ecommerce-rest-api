package ro.bogdancoseru.ecommercerestapi.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.bogdancoseru.ecommercerestapi.entity.product.Product;
import ro.bogdancoseru.ecommercerestapi.repository.ProductRepository;

@Service
@Transactional
@RequiredArgsConstructor
@CacheConfig(cacheNames={"products"})
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
