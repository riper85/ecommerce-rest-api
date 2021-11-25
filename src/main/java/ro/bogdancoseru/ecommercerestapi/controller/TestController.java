package ro.bogdancoseru.ecommercerestapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.bogdancoseru.ecommercerestapi.dto.user.UserDto;
import ro.bogdancoseru.ecommercerestapi.entity.user.User;
import ro.bogdancoseru.ecommercerestapi.security.JwtTokenService;
import ro.bogdancoseru.ecommercerestapi.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class TestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenService jwtTokenUtil;

    @PostMapping({ "/secure" })
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String securePage() {
        return "Secure page";
    }

    @PostMapping(value = "/secure/getcurrentuser")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public UserDto getAuthenticatedUser(HttpServletRequest request) {

        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Optional<User> user = userService.findUserByEmail(username);

        ModelMapper modelMapper = new ModelMapper();
        UserDto userDto = modelMapper.map(user.get(), UserDto.class);

        return userDto;
    }


    @RequestMapping({ "/test" })
    public String test() {
        return "test page";
    }

}