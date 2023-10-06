package com.codegym.product_manager.repository;

import com.codegym.product_manager.model.Product;

public interface ProductReository {

    void add(Product product);
    void delete(int id);
}
