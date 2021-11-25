package ro.bogdancoseru.ecommercerestapi.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.bogdancoseru.ecommercerestapi.entity.user.User;
import ro.bogdancoseru.ecommercerestapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@CacheConfig(cacheNames={"users"})
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @CacheEvict(allEntries=true)
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @CacheEvict(allEntries=true)
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Cacheable
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
