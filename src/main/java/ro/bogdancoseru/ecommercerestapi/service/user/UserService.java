package ro.bogdancoseru.ecommercerestapi.service.user;

import ro.bogdancoseru.ecommercerestapi.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    void deleteUser(User user);
    public Optional<User> findUserByName(String name);
    public Optional<User> findUserByEmail(String email);
    List<User> getAllUsers();
}
