package com.example.demo.Repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameProductContainingOrTypeProduct_NameTypeProductOrderByIdAsc(String key1, String key2, Pageable pageable);
}
