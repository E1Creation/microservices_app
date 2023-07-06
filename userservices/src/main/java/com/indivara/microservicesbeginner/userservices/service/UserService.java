package com.indivara.microservicesbeginner.userservices.service;


import com.indivara.microservicesbeginner.userservices.dto.response.ResponseMessage;
import com.indivara.microservicesbeginner.userservices.entity.User;
import com.indivara.microservicesbeginner.userservices.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findbyId(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User dengan id : "+ id + " tidak ditemukkan"));
    }

    public User update(Long id, User user){
        User saveUser = findbyId(id);
        if(user.getUsername() != null && !user.getUsername().isEmpty()) saveUser.setUsername(user.getUsername());
        if(user.getEmail() != null && !user.getEmail().isEmpty()) saveUser.setEmail(user.getEmail());
        if(user.getPassword() != null && !user.getPassword().isEmpty()) saveUser.setPassword(user.getPassword());
        if(user.getPhoneNumber() != null && !user.getPhoneNumber().isEmpty()) saveUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(user);
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public ResponseMessage deleteById(Long id){
        findbyId(id);
        userRepository.deleteById(id);
        return ResponseMessage.builder().code(201).message("Data dengan id " + id + " berhasil dihapus").build();
    }
}
