package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> finAll();
    void save (Service service);
}
