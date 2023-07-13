package com.indivara.apigateway.config;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indivara.apigateway.outbond.UserEndPoint;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


@Data
@Configuration
@Slf4j
@ConfigurationProperties(prefix = "outbound.user.http-client")
public class UserHttpClientConfiguration {
    private String baseUrl;
    @Bean
    public Retrofit userRetrofit(
            UserHttpClientConfiguration configuration
    ){

        log.info("Retrofit Initialize..., url : "+ configuration.baseUrl);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .baseUrl(configuration.getBaseUrl())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Bean
    public UserEndPoint userEndPoint(
            @Qualifier("userRetrofit") Retrofit retrofit
    ){
        return retrofit.create(UserEndPoint.class);
    }

}
