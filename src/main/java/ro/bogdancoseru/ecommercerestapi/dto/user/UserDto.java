package ro.bogdancoseru.ecommercerestapi.dto.user;

import lombok.*;

import java.util.UUID;

/**
 * This is the user Dto
 *
 * @author Mircea Stan
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String previousEmail;
    private String email;
    private String roleName;
    private String userDetailsPhone;
    private String userDetailsAddress;
    private Integer userDetailsAge;
}
