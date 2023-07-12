package com.indivara.productrestclient;

import com.indivara.productrestclient.dto.response.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductService {
    @GET("/api/v1/product/{id}")
    Call<Product> getProductById(@Path("id") Long id);
}
