package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {

    void create(int id,Product product);

    List<Product> findAll();

    Product findById(int id);
    Product findByName(String name);

    void update(int id, Product product);

    void remove(int id);

}
