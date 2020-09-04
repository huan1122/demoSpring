package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    private Integer orderId;
    private String orderName;
    private String description;
    private Customers customers;
    private Product product;
    private Double amount;
    private Double discount;
    private Double total;
    private Double totalAmount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ORDER_ID")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    @Column(name = "NAME")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JoinColumn(name = "CUSTOMER_ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Column(name = "AMOUNT")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    @Column(name = "DISCOUNT")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    @Column(name = "TOTAL")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    @Column(name = "TOTAL_AMOUNT")
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Orders(Integer orderId, String orderName, String description, Customers customers, Product product, Double amount, Double discount, Double total,Double totalAmount) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.description = description;
        this.customers = customers;
        this.product = product;
        this.amount = amount;
        this.discount = discount;
        this.total = total;
        this.totalAmount = totalAmount;
    }

    public Orders() {
        super();
    }

}
