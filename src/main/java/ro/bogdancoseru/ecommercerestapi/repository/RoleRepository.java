package ro.bogdancoseru.ecommercerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.bogdancoseru.ecommercerestapi.entity.user.Role;
import ro.bogdancoseru.ecommercerestapi.entity.user.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName roleName);
}
