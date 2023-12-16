package com.example.customer.repository.Customer;

import com.example.customer.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> showListCustomer();
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
}
