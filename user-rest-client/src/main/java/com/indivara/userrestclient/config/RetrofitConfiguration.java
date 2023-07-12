package com.indivara.userrestclient.config;


import com.indivara.userrestclient.UserService;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfiguration {
        public final String baseUrlUser = "http://localhost:8081/";
        @Bean
        public UserService retrofitUser(){
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit retrofit =  new Retrofit.Builder()
                    .baseUrl(baseUrlUser)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            return  retrofit.create(UserService.class);
        }
}
