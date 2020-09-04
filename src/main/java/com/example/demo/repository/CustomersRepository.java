package com.example.demo.repository;

import com.example.demo.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

@EnableJpaRepositories
public interface CustomersRepository extends JpaRepository<Customers,Integer> {
    @Query("select c from Customers c")
    List<Customers> getListCustomer();

    @Query("select  c from Customers c where c.customerId = :id")
    Customers getDetailCustomer(@Param("id") Integer id);

    @Query("delete from Customers c where c.customerId = :id")
    int removeCustomer (@Param("id") Integer id);
}