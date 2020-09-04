package com.example.demo.service;

import com.example.demo.model.Customers;

import java.util.List;

public interface CustomerService {
    List<Customers> getListCustomers();
    Customers getDetailCustomer(Integer id);
    void saveCustomer(Customers tblUsers);
    void updateCustomer(Customers tblUsers);
    int removeCustomer(Integer id);
}
