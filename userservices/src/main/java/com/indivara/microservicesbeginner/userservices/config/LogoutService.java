package com.indivara.microservicesbeginner.userservices.config;


import com.indivara.microservicesbeginner.userservices.entity.User;
import com.indivara.microservicesbeginner.userservices.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final UserRepository userRepository;
    private final RedisOperations<String,String> redisOperations;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if(authHeader == null || !authHeader.startsWith("Bearer ")) return;
        jwt = authHeader.substring(7);
        User user = userRepository.findByToken(jwt).orElse(null);
        if(user != null) {
            user.setToken(null);
            String key = "user:"+user.getUsername()+":"+user.getId();
            redisOperations.delete(key);
            userRepository.save(user);
            SecurityContextHolder.clearContext();
        }
    }
}
