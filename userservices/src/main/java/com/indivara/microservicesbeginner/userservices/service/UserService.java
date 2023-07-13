package com.indivara.microservicesbeginner.userservices.service;
import com.indivara.microservicesbeginner.userservices.dto.request.RegisterUser;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthenticationResponse;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthorizationResponse;
import com.indivara.microservicesbeginner.userservices.dto.response.ResponseMessage;
import com.indivara.microservicesbeginner.userservices.entity.User;
import java.util.List;

public interface UserService {
     List<User> findAll();
     User findbyId(Long id);
     AuthenticationResponse create(RegisterUser user);
     AuthorizationResponse getUserByToken(String token);
     ResponseMessage deleteById(Long id);
}
