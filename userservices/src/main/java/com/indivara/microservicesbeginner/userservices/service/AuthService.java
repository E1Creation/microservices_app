package com.indivara.microservicesbeginner.userservices.service;

import com.indivara.microservicesbeginner.userservices.dto.request.AuthenticateRequest;
import com.indivara.microservicesbeginner.userservices.dto.request.RegisterUser;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse auth(AuthenticateRequest request);
    AuthenticationResponse register(RegisterUser request);
}
