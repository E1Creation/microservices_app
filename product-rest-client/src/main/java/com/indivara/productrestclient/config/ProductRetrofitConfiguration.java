package com.indivara.productrestclient.config;

import com.indivara.productrestclient.ProductService;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Configuration
public class ProductRetrofitConfiguration {

        public final String baseUrlProduct = "http://localhost:8082/";
        @Bean
        public ProductService retrofitProduct(){
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit retrofit =   new Retrofit.Builder()
                    .baseUrl(baseUrlProduct)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            return retrofit.create(ProductService.class);
        }
}
