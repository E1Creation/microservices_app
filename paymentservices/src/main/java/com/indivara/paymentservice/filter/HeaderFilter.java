package com.indivara.paymentservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class HeaderFilter implements Filter {

    private String authHeader;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Header Filter running ....");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String header = httpRequest.getHeader("Authorization");
        httpResponse.setHeader("Authorization", header);
        authHeader = header;
        chain.doFilter(httpRequest,httpResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    public String getAuthHeader(){
        return authHeader;
    }

}
