package com.example.demo.Service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);
    Page<Product> findAllProductByname(String key,Pageable pageable);

    Iterable<Product> findAllProduct();

    Product findProdcutById(int id);

    void saveProdcut(Product product);

    void deleteProduct(Product product);
}
