package ro.bogdancoseru.ecommercerestapi.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.bogdancoseru.ecommercerestapi.entity.user.Role;
import ro.bogdancoseru.ecommercerestapi.entity.user.RoleName;
import ro.bogdancoseru.ecommercerestapi.repository.RoleRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> findRoleByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
