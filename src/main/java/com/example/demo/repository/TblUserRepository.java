package com.example.demo.repository;

import com.example.demo.model.TblUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface TblUserRepository {
    List<TblUsers> getListUser();
    TblUsers getDetailUser(Integer id);
    void saveUser(TblUsers tblUsers);
    void updateUser(TblUsers tblUsers);
    int deleteUser(Integer id);
}
