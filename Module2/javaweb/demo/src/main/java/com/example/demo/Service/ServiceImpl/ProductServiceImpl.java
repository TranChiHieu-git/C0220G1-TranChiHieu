package com.example.demo.Service.ServiceImpl;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllProductByname(String key, Pageable pageable) {
        return productRepository.findAllByNameProductContainingOrTypeProduct_NameTypeProductOrderByIdAsc(key, key, pageable);
    }

    @Override
    public Iterable<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProdcutById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProdcut(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
