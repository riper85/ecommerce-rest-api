package ro.bogdancoseru.ecommercerestapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableCaching
public class EcommercerestapiApplication{
	public static void main(String[] args) {
		SpringApplication.run(EcommercerestapiApplication.class, args);
	}
}
