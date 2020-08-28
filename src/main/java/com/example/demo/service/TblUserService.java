package com.example.demo.service;

import com.example.demo.model.TblUsers;

import java.util.List;

public interface TblUserService {
    List<TblUsers> getListUser();

    TblUsers getDetailUser(Integer id);

    void saveUser(TblUsers tblUsers);

    void updateUser(TblUsers tblUsers);

    int deleteUser(Integer id);
}
