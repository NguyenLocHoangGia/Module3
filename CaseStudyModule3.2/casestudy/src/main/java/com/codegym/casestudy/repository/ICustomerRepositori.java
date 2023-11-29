package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepositori {
    List<Customer> finAll();
    List<Customer> findName();
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findByName (String name);
    Boolean update(Customer customer);
    Boolean delete(int  id);

}
