package com.codegym.furama.service.Service;

import com.codegym.furama.model.admin.ServiceModel.TypeRent.TypeRent;
import com.codegym.furama.repository.Service.TypeRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeRentServiceImpl implements TypeRentSerVice {
    @Autowired
    TypeRentRepository typeRentRepository;

    @Override
    public Iterable<TypeRent> findAllTypeRent() {
        return typeRentRepository.findAll();
    }

    @Override
    public TypeRent findTypeRentById(int id) {
        return typeRentRepository.findById(id).orElse(null);
    }
}
