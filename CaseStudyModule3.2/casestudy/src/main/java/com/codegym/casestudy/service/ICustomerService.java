package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> finAll();
    void save (Customer customer);
    Customer findId (int id);
    void update ( Customer customer);
    void delete (int id);
}
