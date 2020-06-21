package com.example.demo.Service.ServiceImpl;

import com.example.demo.Repository.TypeProductRepository;
import com.example.demo.Service.TypeProductService;
import com.example.demo.model.TypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeProductServiceImpl implements TypeProductService {
    @Autowired
    TypeProductRepository typeProductRepository;

    @Override
    public Iterable<TypeProduct> findAllTypeProduct() {
        return typeProductRepository.findAll();
    }

    @Override
    public TypeProduct findTypeProductById(int id) {
        return typeProductRepository.findById(id).orElse(null);
    }
}
