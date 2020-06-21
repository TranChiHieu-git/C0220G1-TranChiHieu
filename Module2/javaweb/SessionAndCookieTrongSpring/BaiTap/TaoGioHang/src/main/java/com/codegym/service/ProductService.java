package com.codegym.service;

import com.codegym.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAllProduct();

    Optional<Product> findProductById(int id);
}
