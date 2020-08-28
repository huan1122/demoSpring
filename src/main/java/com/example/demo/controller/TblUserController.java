package com.example.demo.controller;

import com.example.demo.model.TblUsers;
import com.example.demo.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TblUserController {
    @Autowired
    TblUserService tblUserService;

    @RequestMapping(value = "/getListUser", method = RequestMethod.GET)
    public ResponseEntity<List<TblUsers>> getListUser() {
        List<TblUsers> list = tblUserService.getListUser();
        return new ResponseEntity<List<TblUsers>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/getDetailUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDetailUser(@PathVariable("id") Integer id) {
        TblUsers user = tblUserService.getDetailUser(id);
        return new ResponseEntity<TblUsers>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResponseEntity<?> saveProduct(@RequestBody TblUsers users, UriComponentsBuilder ucBuilder) {
        tblUserService.saveUser(users);
        HttpHeaders http = new HttpHeaders();
        http.setLocation(ucBuilder.path("/api/saveProduct/{id}").buildAndExpand(users.getUserId()).toUri());
        return new ResponseEntity<String>(http, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id, @RequestBody TblUsers users) {
        TblUsers p = tblUserService.getDetailUser(id);
        p.setFirstName(users.getFirstName());
        p.setLastName(users.getLastName());
        p.setAddress(users.getAddress());
        p.setPhone(users.getPhone());
        p.setBirth(users.getBirth());
        p.setEmail(users.getEmail());
        p.setPosition(users.getPosition());
        p.setDepartments(users.getDepartments());
        tblUserService.updateUser(p);
        return ResponseEntity.ok(p);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login() {
        return null;
    }
}
