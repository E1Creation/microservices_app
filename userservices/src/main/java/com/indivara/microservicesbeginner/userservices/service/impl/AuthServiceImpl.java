package com.indivara.microservicesbeginner.userservices.service.impl;


import com.indivara.microservicesbeginner.userservices.config.JwtService;
import com.indivara.microservicesbeginner.userservices.dto.request.AuthenticateRequest;
import com.indivara.microservicesbeginner.userservices.dto.request.RegisterUser;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthenticationResponse;
import com.indivara.microservicesbeginner.userservices.entity.User;
import com.indivara.microservicesbeginner.userservices.repo.UserRepository;
import com.indivara.microservicesbeginner.userservices.service.AuthService;
import com.indivara.microservicesbeginner.userservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RedisOperations<String, String> redisOperations;

    @Override
    public AuthenticationResponse auth(AuthenticateRequest request) {
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        String jwtToken = jwtService.generateToken(user);
        String key = "user:"+request.getUsername()+":"+user.getId();
        user.setToken(jwtToken);
        if(redisOperations.opsForSet().members(key) != null){
            redisOperations.delete(key);
            redisOperations.opsForSet().add(key, jwtToken);
        } else redisOperations.opsForSet().add(key,jwtToken);
        userRepository.save(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse register(RegisterUser request) {
        return userService.create(request);
    }

}
