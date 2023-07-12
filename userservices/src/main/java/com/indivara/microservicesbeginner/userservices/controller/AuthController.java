package com.indivara.microservicesbeginner.userservices.controller;


import com.indivara.microservicesbeginner.userservices.dto.request.AuthenticateRequest;
import com.indivara.microservicesbeginner.userservices.dto.request.RegisterUser;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthenticationResponse;
import com.indivara.microservicesbeginner.userservices.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> auth(@RequestBody AuthenticateRequest request){
        return new ResponseEntity<>(authService.auth(request), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterUser request){
        return new ResponseEntity<>(authService.register(request), HttpStatus.CREATED);
    }



}
