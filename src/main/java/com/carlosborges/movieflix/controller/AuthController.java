package com.carlosborges.movieflix.controller;
import com.carlosborges.movieflix.config.TokenService;
import com.carlosborges.movieflix.controller.request.LoginRequest;
import com.carlosborges.movieflix.controller.request.UserRequest;
import com.carlosborges.movieflix.controller.response.LoginResponse;
import com.carlosborges.movieflix.controller.response.UserResponse;
import com.carlosborges.movieflix.entity.User;
import com.carlosborges.movieflix.exceptions.UserNameOrPasswordInvalidException;
import com.carlosborges.movieflix.mapper.UserMapper;
import com.carlosborges.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movieflix/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registar(@RequestBody UserRequest request) {
        User savedUser = userService.saveUser(UserMapper.toUser(request  ));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
            Authentication authentication = authenticationManager.authenticate(userAndPass);

            User user = (User) authentication.getPrincipal();

            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new LoginResponse(token));

        } catch (BadCredentialsException e) {
            throw new UserNameOrPasswordInvalidException("Usuário ou senha inválido.");

        }

    }

}
