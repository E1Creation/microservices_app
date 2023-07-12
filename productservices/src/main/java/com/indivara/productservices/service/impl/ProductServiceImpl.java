package com.indivara.productservices.service.impl;


import com.indivara.productservices.entity.Product;
import com.indivara.productservices.repo.ProductRepository;
import com.indivara.productservices.response.ResponseMessage;
import com.indivara.productservices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findbyId(Long id){
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product dengan id : "+ id + " tidak ditemukkan"));
    }

    public Product update(Long id, Product product){
        Product saveProduct = findbyId(id);
        if(product.getName() != null && !product.getName().isEmpty()) saveProduct.setName(product.getName());
        if(product.getDescription() != null && !product.getDescription().isEmpty()) saveProduct.setDescription(product.getDescription());
        if(product.getPrice() != null) saveProduct.setPrice(product.getPrice());
        return productRepository.save(saveProduct);
    }

    public Product create(Product product){
        return productRepository.save(product);
    }

    public ResponseMessage deleteById(Long id){
        findbyId(id);
        productRepository.deleteById(id);
        return ResponseMessage.builder().code(201).message("Data dengan id " + id + " berhasil dihapus").build();
    }
}
