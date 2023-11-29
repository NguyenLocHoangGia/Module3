package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.impl.CustomerRepository;
import com.codegym.casestudy.service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> finAll() {
        return customerRepository.finAll();
    }

    @Override
    public void save(Customer customer) {
            customerRepository.save(customer);
    }

    @Override
    public Customer findId(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public void delete(int id) {
            customerRepository.delete(id);
    }
}
