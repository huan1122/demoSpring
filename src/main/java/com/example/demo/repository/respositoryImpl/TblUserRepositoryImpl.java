package com.example.demo.repository.respositoryImpl;

import com.example.demo.model.TblUsers;
import com.example.demo.repository.TblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class TblUserRepositoryImpl implements TblUserRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<TblUsers> getListUser() {
        StringBuilder builder = new StringBuilder();
        builder.append("select t from TblUsers as t");
        List<TblUsers> list = entityManager.createQuery(builder.toString()).getResultList();
        return list;
    }

    @Override
    public TblUsers getDetailUser(Integer id) {
        StringBuilder builder = new StringBuilder();
        builder.append("select t from TblUsers where t.userId = ?");
        Query query = entityManager.createQuery(builder.toString());
        query.setParameter(1,id);
        return (TblUsers) query.getResultList().get(0);
    }

    @Override
    public void saveUser(TblUsers tblUsers) {
        StringBuilder str = new StringBuilder();
        str.append("Insert into tbl_users (FIRST_NAME,LAST_NAME,BIRTHDAY,ADDRESS,PHONE,DEPARTMENTS,POSITION,EMAIL,USERNAME,PASSWORD) values(?,?,?,?,?,?,?,?,?,?)");
        Query query = entityManager.createNativeQuery(str.toString());
        query.setParameter(1,tblUsers.getFirstName());
        query.setParameter(2,tblUsers.getLastName());
        query.setParameter(3,tblUsers.getBirth());
        query.setParameter(4,tblUsers.getAddress());
        query.setParameter(5,tblUsers.getPhone());
        query.setParameter(6,tblUsers.getDepartments());
        query.setParameter(7,tblUsers.getPosition());
        query.setParameter(8,tblUsers.getEmail());
        query.setParameter(9,tblUsers.getUserName());
        query.setParameter(10,tblUsers.getPassword());
        query.executeUpdate();
    }

    @Override
    public void updateUser(TblUsers tblUsers) {
        saveUser(tblUsers);
    }

    @Override
    public int deleteUser(Integer id) {
        StringBuilder str = new StringBuilder();
        str.append("delete from TblUsers where userId = ?");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter(1,id);
        return query.executeUpdate();
    }
}
