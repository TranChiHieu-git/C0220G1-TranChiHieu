package com.codegym.furama.service.Service;

import com.codegym.furama.model.admin.ServiceModel.TypeService.TypeService;

public interface TypeSerViceService {
    Iterable<TypeService> findAllTypeService();

    TypeService findTypeServiceById(int id);
}
