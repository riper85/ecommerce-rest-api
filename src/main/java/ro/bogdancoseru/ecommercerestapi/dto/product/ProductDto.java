package ro.bogdancoseru.ecommercerestapi.dto.product;


import lombok.*;
import java.math.BigDecimal;

@Value
public class ProductDto {
    Integer id;
    String name;
    String description;
    String category;
    String subCategory;
    String brand;
    Integer stockCount;
    BigDecimal price;
    Integer discount;
    String imageUrl;
}