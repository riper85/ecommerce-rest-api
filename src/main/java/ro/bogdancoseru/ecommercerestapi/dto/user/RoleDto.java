package ro.bogdancoseru.ecommercerestapi.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class RoleDto {

    private Integer id;

    @NotBlank
    private String name;

}
