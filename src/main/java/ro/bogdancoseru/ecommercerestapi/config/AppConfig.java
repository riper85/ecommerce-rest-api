package ro.bogdancoseru.ecommercerestapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean("passencoder")
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
