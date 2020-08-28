package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product getDetailProduct(Integer id);

    Product updateProduct(Product product);

    Product saveProduct(Product product);
}
