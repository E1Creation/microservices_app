package com.indivara.apigateway.outbond;

import com.indivara.apigateway.dto.response.AuthorizationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import static com.indivara.apigateway.constant.Header.AUTHORIZATION;

public interface UserEndPoint {
    @GET("/api/v1/user/credential")
    Call<AuthorizationResponse> authorizeRequest(
            @Header(AUTHORIZATION) String token
    );
}
