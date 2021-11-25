package ro.bogdancoseru.ecommercerestapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleStateException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ro.bogdancoseru.ecommercerestapi.dto.user.*;
import ro.bogdancoseru.ecommercerestapi.entity.user.Role;
import ro.bogdancoseru.ecommercerestapi.entity.user.User;
import ro.bogdancoseru.ecommercerestapi.security.JwtTokenService;
import ro.bogdancoseru.ecommercerestapi.service.RoleService;
import ro.bogdancoseru.ecommercerestapi.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class JwtTokenController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenUtil;
    private final RoleService roleService;
    private final PasswordEncoder passencoder;
    private final UserService userService;

    @PostMapping(value = "/token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginUserDto authenticationRequest) throws Exception {

        final Authentication auth = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        SecurityContextHolder.getContext().setAuthentication(auth);

        return ResponseEntity.ok(new JwtAuthResponseDto(jwtTokenUtil.generateToken(auth)));
    }

    @PostMapping(value = "/register")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveUser(@RequestBody @Valid RegisterUserDto registerUserDto) throws Exception {

        ModelMapper modelMapper = new ModelMapper();
        User newUser = modelMapper.map(registerUserDto, User.class);
        Optional<Role> role = roleService.findRoleByName(newUser.getRole().getName());

        newUser.getUserDetails().setUser(newUser);
        newUser.setRole(role.get());

        newUser.setPassword(passencoder.encode(newUser.getPassword()));

        userService.saveUser(newUser);

        UserDto userDto = modelMapper.map(newUser, UserDto.class);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping(value = "/listusers", produces = "application/json")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> listUsers() {

        List<User> users = userService.getAllUsers();
        ModelMapper modelMapper = new ModelMapper();
        List<UserDto> userDto = users.stream()
                                    .map(user -> modelMapper.map(user, UserDto.class))
                                    .collect(Collectors.toList());
        ListUsersDto listUsersDto = new ListUsersDto(userDto.size(), userDto);

        return ResponseEntity.ok(listUsersDto);
    }

    @DeleteMapping(value = "/delete", produces = "application/json")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteUser(@RequestParam(value = "username") String username) {

        Optional<User> user = userService.findUserByEmail(username);
        log.warn(username);

        if (user.isPresent()) {
            log.warn(String.valueOf(user.get()));
            try {
                userService.deleteUser(user.get());
                return new ResponseEntity<>("User deleted", HttpStatus.ACCEPTED);
            } catch (StaleStateException exception) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!");
            }

        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
    }

    private Authentication authenticate(String username, String password) throws DisabledException, BadCredentialsException{
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }  catch (DisabledException e) {
            throw new DisabledException(e.toString(), e);
            //throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
            //throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}