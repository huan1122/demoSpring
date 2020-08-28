package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getListProduct();
    }

    @Override
    public Product getDetailProduct(Integer id) {
        return productRepository.getDetailProduct(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return saveProduct(product);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
