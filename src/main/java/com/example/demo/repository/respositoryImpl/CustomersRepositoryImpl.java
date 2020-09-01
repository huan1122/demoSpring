package com.example.demo.repository.respositoryImpl;

import com.example.demo.model.Customers;
import com.example.demo.repository.CustomersRepository;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CustomersRepositoryImpl implements CustomersRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Customers> getListCustomer() {
        StringBuilder str = new StringBuilder();
        str.append("select c from Customers");
        List<Customers> list = entityManager.createQuery(str.toString()).getResultList();
        return list;
    }

    @Override
    public Customers getDetailCustomer(Integer id) {
        StringBuilder str = new StringBuilder();
        str.append("select c from Customers c");
        str.append(" where c.customerId = ?");
        Query query = entityManager.createQuery(str.toString());
        query.setParameter(1,id);
        Customers cus =  (Customers) query.getResultList().get(0);
        return cus;
    }

    @Override
    public void saveCustomer(Customers cus) {
        StringBuilder str = new StringBuilder();
        str.append("INSERT iNTO customers (CUSTOMER_NAME,ADDRESS,PHONE,DELIVERY_ADDRESS,BIRTHDAY) values (?,?,?,?,?)");
        Query query = entityManager.createNativeQuery(str.toString());
        query.setParameter(1,cus.getCustomerName());
        query.setParameter(2,cus.getAddress());
        query.setParameter(3,cus.getPhone());
        query.setParameter(4,cus.getDeliveryAddress());
        query.setParameter(5,cus.getBirthDate());
        query.executeUpdate();
    }

    @Override
    public void updateCustomers(Customers cus) {
        entityManager.
    }

    @Override
    public int removeCustomer(Integer id) {
        return 0;
    }
}
