package com.indivara.apigateway.filter;

import com.indivara.apigateway.dto.response.AuthorizationResponse;
import com.indivara.apigateway.error.UnAuthorizedException;
import com.indivara.apigateway.outbond.UserRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.indivara.apigateway.constant.Header.*;

@Component
@Slf4j
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.NameConfig> {

    private final UserRestClient userRestClient;

    @Autowired
    public AuthenticationFilter(UserRestClient userRestClient) {
        super(NameConfig.class);
        this.userRestClient = userRestClient;
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        log.info("Gateway Filter berjalan");
        return (exchange, chain) -> {
            final String authorizationHeader = getAuthorizationHeader(exchange.getRequest().getHeaders());
            final AuthorizationResponse authorizationResponse = authorizeRequest(authorizationHeader);
            exchange
                    .getRequest()
                    .mutate()
                    .header(X_MEMBER_ID, String.valueOf(authorizationResponse.getId()))
                    .header(X_USERNAME, authorizationResponse.getUsername())
                    .build();

            return chain.filter(exchange);
        };
    }

    private AuthorizationResponse authorizeRequest(String authorizationHeader) {
        final AuthorizationResponse response = userRestClient.authorizationResponse(authorizationHeader);
        log.info("Token : "+ authorizationHeader);
        log.info("username : " + response.getUsername());
        if(response == null || response.getId() == null) throw new UnAuthorizedException();
        return response;
    }

    private String getAuthorizationHeader(HttpHeaders headers) {
            final String authorizationHeader = headers.getFirst(AUTHORIZATION);
            if(!StringUtils.hasText(authorizationHeader) || !authorizationHeader.contains("Bearer")) throw new UnAuthorizedException();
            return authorizationHeader;
    }

}
