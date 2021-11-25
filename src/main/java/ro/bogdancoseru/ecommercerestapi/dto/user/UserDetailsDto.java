package ro.bogdancoseru.ecommercerestapi.dto.user;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * This is the user details Dto
 *
 * @author Mircea Stan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {

    private Integer id;
    @NotBlank
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private Integer age;

}
