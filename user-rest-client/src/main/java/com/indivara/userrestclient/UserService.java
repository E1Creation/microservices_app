package com.indivara.userrestclient;

import com.indivara.userrestclient.dto.response.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface UserService {


    @GET("/api/v1/user/{id}")
    Call<User> getUserById(@Path("id") Long id, @Header("Authorization") String authHeader);
}
