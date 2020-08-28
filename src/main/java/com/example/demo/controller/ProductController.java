package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getListProduct", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getListProduct() {
        List<Product> list = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/getDetailProduct/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getDetailProduct(@PathVariable("id") Integer id) {
        Product product = productService.getDetailProduct(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public ResponseEntity<?> saveProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        System.out.println(product.getName() + "acs");
        productService.saveProduct(product);
        HttpHeaders http = new HttpHeaders();
        http.setLocation(ucBuilder.path("/api/saveProduct/{id}").buildAndExpand(product.getProductId()).toUri());
        return new ResponseEntity<String>(http, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product p = productService.getDetailProduct(id);
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        productService.updateProduct(p);
        return ResponseEntity.ok(p);
    }
}
