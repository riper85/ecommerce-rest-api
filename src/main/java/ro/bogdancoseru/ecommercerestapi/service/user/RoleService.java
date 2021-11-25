package ro.bogdancoseru.ecommercerestapi.service.user;

import ro.bogdancoseru.ecommercerestapi.entity.user.Role;
import ro.bogdancoseru.ecommercerestapi.entity.user.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findRoleByName(RoleName name);
}
