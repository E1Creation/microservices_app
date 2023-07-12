package com.indivara.microservicesbeginner.userservices.service.impl;

import com.indivara.microservicesbeginner.userservices.config.JwtService;
import com.indivara.microservicesbeginner.userservices.dto.request.RegisterUser;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthenticationResponse;
import com.indivara.microservicesbeginner.userservices.dto.response.ResponseMessage;
import com.indivara.microservicesbeginner.userservices.entity.Customer;
import com.indivara.microservicesbeginner.userservices.entity.User;
import com.indivara.microservicesbeginner.userservices.enumeration.Role;
import com.indivara.microservicesbeginner.userservices.repo.UserRepository;
import com.indivara.microservicesbeginner.userservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final RedisOperations<String,String> redisOperations;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findbyId(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User dengan id : "+ id + " tidak ditemukkan"));
    }

    public AuthenticationResponse create(RegisterUser request){
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .isEnabled(true)
                .isAccountLocked(false)
                .build();
        String jwtToken = jwtService.generateToken(user);
        Customer customer = Customer
                .builder()
                .name(request.getFullName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .gender(request.getGender())
                .build();
        user.setCustomer(customer);
        user.setToken(jwtToken);
        customer.setUser(user);
        User user1 = userRepository.save(user);
        String key = "user:"+request.getUsername()+":"+user1.getId();
        redisOperations.opsForSet().add(key, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public ResponseMessage deleteById(Long id){
        findbyId(id);
        userRepository.deleteById(id);
        return ResponseMessage.builder().code(201).message("Data dengan id " + id + " berhasil dihapus").build();
    }
}
