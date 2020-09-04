package com.example.demo.controller;

import com.example.demo.model.Customers;
import com.example.demo.repository.CustomersRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CustomersController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "/getListCustomer",method = RequestMethod.GET)
    public ResponseEntity<List<Customers>> getListCustomer(){
        List<Customers> list = customerService.getListCustomers();
        return new ResponseEntity<List<Customers>>(list, HttpStatus.OK);
    }
    @RequestMapping(value = "/getDetailCustomer/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getDetailCustomer(@PathVariable("id") Integer id){
        Customers cus = customerService.getDetailCustomer(id);
        return new ResponseEntity<Customers>(cus,HttpStatus.OK);
    }
    @RequestMapping(value = "/saveCustomer",method = RequestMethod.POST)
    public ResponseEntity<?> saveCustomer(Customers cus, UriComponentsBuilder ucBuilder){
        customerService.saveCustomer(cus);
        HttpHeaders http = new HttpHeaders();
        http.setLocation(ucBuilder.path("/api/saveProduct/{id}").buildAndExpand(cus.getCustomerId()).toUri());
        return new ResponseEntity<String>(http, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/updateCustomer/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Integer id,Customers cus){
        Customers c = customerService.getDetailCustomer(id);
        c.setAddress(cus.getAddress());
        c.setBirthDate(cus.getBirthDate());
        c.setCustomerName(cus.getCustomerName());
        c.setDeliveryAddress(cus.getDeliveryAddress());
        c.setPhone(cus.getPhone());
        customerService.updateCustomer(c);
        return ResponseEntity.ok(c);
    }
    @RequestMapping(value = "/deleteCustomer/{id}",method = RequestMethod.DELETE)
    public Integer removeCustomer(@PathVariable("id") Integer id){
        return customerService.removeCustomer(id);
    }
}
