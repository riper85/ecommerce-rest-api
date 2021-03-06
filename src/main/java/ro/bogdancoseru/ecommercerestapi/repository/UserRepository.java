package ro.bogdancoseru.ecommercerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.bogdancoseru.ecommercerestapi.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);
    Optional<User> findByEmail(String email);
}
