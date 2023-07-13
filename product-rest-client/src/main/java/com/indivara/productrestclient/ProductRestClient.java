package com.indivara.productrestclient;

import com.indivara.productrestclient.dto.response.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProductRestClient {
    @Autowired
    private ProductService productService;

    public Product getDetailProductById(Long id, String authHeader){
        Product product = null;
        try{
            product = productService.getProductById(id, authHeader).execute().body();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return product;
    }
}
