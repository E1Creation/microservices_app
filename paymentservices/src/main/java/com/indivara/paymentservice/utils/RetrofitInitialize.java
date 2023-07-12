//package com.indivara.paymentservice.utils;
//
//import com.indivara.paymentservice.network.api.ProductService;
//import com.indivara.paymentservice.network.api.UserService;
//import okhttp3.OkHttpClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//@Configuration
//public class RetrofitInitialize {
//    public final String baseUrlUser = "http://localhost:8081/";
//    public final String baseUrlProduct = "http://localhost:8082/";
//    @Bean
//    public UserService retrofitUser(){
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        Retrofit retrofit =  new Retrofit.Builder()
//                .baseUrl(baseUrlUser)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build();
//        return  retrofit.create(UserService.class);
//    }
//    @Bean
//    public ProductService retrofitProduct(){
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        Retrofit retrofit =   new Retrofit.Builder()
//                .baseUrl(baseUrlProduct)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build();
//        return retrofit.create(ProductService.class);
//    }
//}
