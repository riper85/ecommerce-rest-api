package ro.bogdancoseru.ecommercerestapi.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * This is the login request class
 *
 * @author Mircea Stan
 */
@Data
public class LoginUserDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
