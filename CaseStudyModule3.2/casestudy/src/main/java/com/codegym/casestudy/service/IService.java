package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Service;

import java.util.List;

public interface IService {
    List<Service> findAll();
    void save(Service service);
}
