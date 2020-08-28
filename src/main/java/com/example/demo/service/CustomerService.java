package com.example.demo.service;

import com.example.demo.model.Customers;
import com.example.demo.model.TblUsers;

import java.util.List;

public interface CustomerService {
    List<Customers> getListCustomers();
    Customers getDetailCustomer();
    void saveCustomer(TblUsers tblUsers);
    void updateCustomer(TblUsers tblUsers);

}
