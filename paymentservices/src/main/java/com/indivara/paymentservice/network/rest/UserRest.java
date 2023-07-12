//package com.indivara.paymentservice.network.rest;
//
//import com.indivara.paymentservice.dto.request.User;
//import com.indivara.paymentservice.network.api.UserService;
//import com.indivara.paymentservice.utils.RetrofitInitialize;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//
//@Component
//public class UserRest {
//
//    @Autowired
//     public UserService userService;
//    public User getDetailUserById(Long id)  {
//        User user = null;
//        try{
//            user = userService.getUserById(id).execute().body();
//        }catch (IOException exception){
//            System.out.println(exception.getMessage());
//        }
//        return user;
//    }
//
//}
