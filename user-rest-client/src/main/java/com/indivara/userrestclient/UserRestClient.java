package com.indivara.userrestclient;

import com.indivara.userrestclient.dto.response.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserRestClient {

    @Autowired
    public UserService userService;
    public User getDetailUserById(Long id, String authHeader)  {
        User user = null;
        try{
            user = userService.getUserById(id, authHeader).execute().body();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        return user;
    }

}
