package com.example.demo.repository;

import com.example.demo.model.Customers;

import java.util.List;

public interface CustomersRepository {
    List<Customers> getListCustomer();
    Customers getDetailCustomer(Integer id);
    void saveCustomer(Customers cus);
    void updateCustomers(Customers cus);
    int removeCustomer (Integer id);
}