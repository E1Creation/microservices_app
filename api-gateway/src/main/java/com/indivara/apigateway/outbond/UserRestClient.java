package com.indivara.apigateway.outbond;


import com.indivara.apigateway.dto.response.AuthorizationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;

import static java.util.Optional.ofNullable;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserRestClient {

    private final UserEndPoint userEndPoint;

    public AuthorizationResponse authorizationResponse(String token){
        log.info("Authorization is running ....");
        Response<AuthorizationResponse> response = null;
        try{
            response = userEndPoint.authorizeRequest(token).execute();
        }catch (IOException e) {
            log.error("Failed to call endpoint Authorize Request", e);
        }
        return ofNullable(response)
                .map(Response::body)
                .orElse(null);
    }

}
