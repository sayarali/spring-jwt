package com.alisayar.springjwt.controller;

import com.alisayar.springjwt.dto.UserDto;
import com.alisayar.springjwt.dto.UserRequestDto;
import com.alisayar.springjwt.dto.UserResponse;
import com.alisayar.springjwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authenticationService.register(userDto));
    }

    @PostMapping("/auth")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(authenticationService.login(userRequestDto));
    }

}
