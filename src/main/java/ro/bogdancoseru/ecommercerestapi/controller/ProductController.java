package ro.bogdancoseru.ecommercerestapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.bogdancoseru.ecommercerestapi.dto.product.ProductDto;
import ro.bogdancoseru.ecommercerestapi.dto.user.UserDto;
import ro.bogdancoseru.ecommercerestapi.entity.product.Product;
import ro.bogdancoseru.ecommercerestapi.service.product.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("isAuthenticated()")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestBody @Valid ProductDto productDto) {

        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productDto, Product.class);
        productService.save(product);
        log.warn(String.valueOf(product));

        return ResponseEntity.ok("ce s a intamplat");
    }

    // TODO ADD
    // TODO DELETE
    // TODO BATCH INSERT
    // TODO LIST ALL PRODUCTS
    // TODO FITERS by - available,
}
