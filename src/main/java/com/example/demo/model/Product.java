package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")

public class Product implements Serializable {
    private Integer productId;
    private String name;
    private Double price;
    private Set<Orders> order = new HashSet<Orders>(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "NAME_PRODUCT")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @OneToMany(mappedBy = "product")
    public Set<Orders> getOrder() {
        return order;
    }

    public void setOrder(Set<Orders> order) {
        this.order = order;
    }

    public Product(Integer productId, String name, Double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }
}
