package com.codegym.product_manager.repository;


import com.codegym.product_manager.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements  IProductReository{

    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Tivi",3,12000));
        products.put(2, new Product(2,"TuLanh",4,11000));
        products.put(3, new Product(3,"Quat",5,10000));
        products.put(4, new Product(4,"Bep",6,14000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public void save(int id,Product product) {
        products.put(id,product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }
}
