package com.example.demo.service.impl;

import com.example.demo.model.TblUsers;
import com.example.demo.repository.TblUserRepository;
import com.example.demo.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblUserServiceImpl implements TblUserService {
    @Autowired
    TblUserRepository tblUserRepository;

    @Override
    public List<TblUsers> getListUser() {

        return tblUserRepository.getListUser();
    }

    @Override
    public TblUsers getDetailUser(Integer id) {
        return tblUserRepository.getDetailUser(id);
    }

    @Override
    public void saveUser(TblUsers tblUsers) {
         tblUserRepository.saveUser(tblUsers);
    }

    @Override
    public void updateUser(TblUsers tblUsers) {
        saveUser(tblUsers);
    }

    @Override
    public int deleteUser(Integer id) {
        return 0;
    }
}
