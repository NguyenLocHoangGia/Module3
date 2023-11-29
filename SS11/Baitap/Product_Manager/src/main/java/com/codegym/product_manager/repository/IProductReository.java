package com.codegym.product_manager.repository;


import com.codegym.product_manager.model.Product;

import java.util.List;

public interface IProductReository {
    List<Product> findAll();
    void delete(int id);
    void save(int id,Product product);
    Product findById(int id);
    void update(int id, Product product);

}
