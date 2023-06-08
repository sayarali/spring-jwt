package com.alisayar.springjwt.service;

import com.alisayar.springjwt.dto.UserDto;
import com.alisayar.springjwt.dto.UserRequestDto;
import com.alisayar.springjwt.dto.UserResponse;
import com.alisayar.springjwt.entity.User;
import com.alisayar.springjwt.repository.UserRepository;
import com.alisayar.springjwt.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    public UserResponse register(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return UserResponse.builder().token(token).build();
    }

    public UserResponse login(UserRequestDto userRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword()));

        User user = userRepository.findByUsername(userRequestDto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return UserResponse.builder().token(token).build();

    }
}
