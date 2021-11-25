package ro.bogdancoseru.ecommercerestapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.bogdancoseru.ecommercerestapi.dto.product.ProductDto;
import ro.bogdancoseru.ecommercerestapi.dto.user.RegisterUserDto;
import ro.bogdancoseru.ecommercerestapi.dto.user.UserDto;
import ro.bogdancoseru.ecommercerestapi.entity.product.Product;
import ro.bogdancoseru.ecommercerestapi.entity.user.Role;
import ro.bogdancoseru.ecommercerestapi.entity.user.User;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    @PostMapping(value = "/addnewproduct")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ProductDto> addProduct(@RequestBody @Valid ProductDto productDto) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        Product newProduct = modelMapper.map(productDto, Product.class);
        log.warn(String.valueOf(newProduct));

        return ResponseEntity.ok(productDto);
    }

    // TODO ADD
    // TODO DELETE
    // TODO BATCH INSERT
    // TODO LIST ALL PRODUCTS
    // TODO FITERS by - available,
}
