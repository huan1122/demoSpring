package com.example.demo.service.impl;

import com.example.demo.model.Customers;
import com.example.demo.model.TblUsers;
import com.example.demo.repository.CustomersRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomersRepository customersRepository;
    @Override
    public List<Customers> getListCustomers() {
        return customersRepository.getListCustomer();
    }

    @Override
    public Customers getDetailCustomer(Integer id) {
        return customersRepository.getDetailCustomer(id);
    }

    @Override
    public void saveCustomer(Customers tblUsers) {
        customersRepository.save(tblUsers);
    }

    @Override
    public void updateCustomer(Customers tblUsers) {
        saveCustomer(tblUsers);
    }

    @Override
    public int removeCustomer(Integer id) {
        return customersRepository.removeCustomer(id);
    }
}
