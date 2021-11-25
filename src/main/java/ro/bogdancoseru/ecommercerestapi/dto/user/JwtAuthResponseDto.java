package ro.bogdancoseru.ecommercerestapi.dto.user;

import lombok.*;

/**
 * This is the JWTAuthentication response class
 *
 * @author Mircea Stan
 */
@Data
public class JwtAuthResponseDto {

    @NonNull
    private final String token;

}
