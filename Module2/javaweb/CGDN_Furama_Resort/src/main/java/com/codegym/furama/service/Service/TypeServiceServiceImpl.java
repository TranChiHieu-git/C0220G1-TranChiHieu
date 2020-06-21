package com.codegym.furama.service.Service;

import com.codegym.furama.model.admin.ServiceModel.TypeService.TypeService;
import com.codegym.furama.repository.Service.TypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceServiceImpl implements TypeSerViceService {
    @Autowired
    TypeServiceRepository typeServiceRepository;

    @Override
    public Iterable<TypeService> findAllTypeService() {
        return typeServiceRepository.findAll();
    }

    @Override
    public TypeService findTypeServiceById(int id) {
        return typeServiceRepository.findById(id).orElse(null);
    }
}
