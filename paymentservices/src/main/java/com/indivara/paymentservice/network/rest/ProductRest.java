//package com.indivara.paymentservice.network.rest;
//
//
//import com.indivara.paymentservice.dto.request.Product;
//import com.indivara.paymentservice.network.api.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class ProductRest {
//
//    @Autowired
//    private ProductService productService;
//
//    public Product getDetailProductById(Long id){
//        Product product = null;
//        try{
//            product = productService.getProductById(id).execute().body();
//        } catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
//        return product;
//    }
//}
