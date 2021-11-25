package ro.bogdancoseru.ecommercerestapi.entity.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private Integer id;

    @NotNull(message = "Product name is required.")
    private String name;
    @NotNull(message = "Product description is required.")
    private String description;
    @NotNull(message = "Product category is required.")
    private String category;

    private String subCategory;

    @NotNull(message = "Product brand is required.")
    private String brand;
    @NotNull(message = "Product count is required.")
    private Integer stockCount;
    @NotNull(message = "Product price is required.")
    private BigDecimal price;
    @NotNull(message = "Product discount is required.")
    private Integer discount;

    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) && getName().equals(product.getName()) && getDescription().equals(product.getDescription()) && getBrand().equals(product.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getBrand());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("category='" + category + "'")
                .add("subCategory='" + subCategory + "'")
                .add("brand='" + brand + "'")
                .add("stockCount=" + stockCount)
                .add("price=" + price)
                .add("discount=" + discount)
                .add("imageUrl='" + imageUrl + "'")
                .toString();
    }
}
