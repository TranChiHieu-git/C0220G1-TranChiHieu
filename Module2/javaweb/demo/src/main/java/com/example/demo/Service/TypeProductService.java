package com.example.demo.Service;

import com.example.demo.model.TypeProduct;

public interface TypeProductService {
    Iterable<TypeProduct> findAllTypeProduct();
    TypeProduct findTypeProductById(int id);
}
