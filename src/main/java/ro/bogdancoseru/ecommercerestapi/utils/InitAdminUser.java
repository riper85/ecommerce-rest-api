package ro.bogdancoseru.ecommercerestapi.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ro.bogdancoseru.ecommercerestapi.entity.user.Role;
import ro.bogdancoseru.ecommercerestapi.entity.user.RoleName;
import ro.bogdancoseru.ecommercerestapi.entity.user.User;
import ro.bogdancoseru.ecommercerestapi.entity.user.UserDetails;
import ro.bogdancoseru.ecommercerestapi.service.RoleService;
import ro.bogdancoseru.ecommercerestapi.service.UserService;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitAdminUser implements CommandLineRunner {

    private final PasswordEncoder passencoder;
    private final UserService userService;
    private final RoleService roleService;

    private static final String EMAIL = "bogdan.coseru@gmail.com";

    @Override
    public void run(String... args) throws Exception {

        Optional<User> user = userService.findUserByEmail(EMAIL);
        Optional<Role> role = roleService.findRoleByName(RoleName.ROLE_ADMIN);

        User newUser;
        if (user.isEmpty() && role.isPresent()) {
            log.warn("Performin insert!");
            newUser = createUser(role.get());
            userService.saveUser(newUser);
        } else {
            log.warn("Performin delete!");
            //log.warn(user.get().toString());
            //userService.deleteUser(user.get());
        }
    }

    private User createUser(Role role){
        UserDetails userDetails = UserDetails
                .builder()
                .address("Bucuresti")
                .phone("+40768023484")
                .age(36)
                .build();

        User adminUser = User
                .builder()
                .email(EMAIL)
                .name("Coseru Ionut Bogdan")
                .password(passencoder.encode("februarie0202"))
                .userDetails(userDetails)
                .role(role)
                .build();

        userDetails.setUser(adminUser);

        return adminUser;
    }
}
