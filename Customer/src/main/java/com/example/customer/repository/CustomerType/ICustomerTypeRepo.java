package com.example.customer.repository.CustomerType;

import com.example.customer.model.CustomerType;

import java.util.List;

public interface ICustomerTypeRepo {
    List<CustomerType> showListCustomerType();
    CustomerType findCustomerType(int id);
}
