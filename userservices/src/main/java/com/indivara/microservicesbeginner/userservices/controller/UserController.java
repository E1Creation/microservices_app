package com.indivara.microservicesbeginner.userservices.controller;


import com.indivara.microservicesbeginner.userservices.dto.request.RegisterUser;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthenticationResponse;
import com.indivara.microservicesbeginner.userservices.dto.response.AuthorizationResponse;
import com.indivara.microservicesbeginner.userservices.dto.response.ResponseMessage;
import com.indivara.microservicesbeginner.userservices.entity.User;
import com.indivara.microservicesbeginner.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponse> create(@RequestBody RegisterUser user){
        return new ResponseEntity<>(userService.create(user),HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.CREATED);
    }

    @GetMapping("/credential")
    public ResponseEntity<AuthorizationResponse> getUserByToken(@RequestHeader("Authorization") String token){
        return new ResponseEntity<>(userService.getUserByToken(token),HttpStatus.OK);
    }
}
