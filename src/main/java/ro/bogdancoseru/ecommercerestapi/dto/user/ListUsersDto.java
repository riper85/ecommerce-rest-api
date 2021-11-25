package ro.bogdancoseru.ecommercerestapi.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListUsersDto {

    private Integer totalCount;
    List<UserDto> userList;

}
