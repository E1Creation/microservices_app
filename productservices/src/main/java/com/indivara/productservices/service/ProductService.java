package com.indivara.productservices.service;


import com.indivara.productservices.entity.Product;
import com.indivara.productservices.repo.ProductRepository;
import com.indivara.productservices.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

public interface ProductService {
    List<Product> findAll();
    Product findbyId(Long id);
    Product update(Long id, Product product);
    Product create(Product product);
    ResponseMessage deleteById(Long id);
}
