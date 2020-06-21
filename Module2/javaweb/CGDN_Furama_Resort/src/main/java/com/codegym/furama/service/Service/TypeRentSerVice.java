package com.codegym.furama.service.Service;

import com.codegym.furama.model.admin.ServiceModel.TypeRent.TypeRent;

public interface TypeRentSerVice {
    Iterable<TypeRent> findAllTypeRent();
    TypeRent findTypeRentById(int id);
}
