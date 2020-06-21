package com.codegym.furama.service.Service;

import com.codegym.furama.model.admin.ServiceModel.Service;
import com.codegym.furama.repository.Service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@org.springframework.stereotype.Service

public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;


    @Override
    public Page<Service> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> findAllServiceByName(String key, Pageable pageable) {
        return serviceRepository.findAllByNameContainingOrTypeRent_NameTypeRentOrTypeService_NameTypeServiceOrStatusOrderById(key, key, key, key, pageable);
    }

    @Override
    public Iterable<Service> findAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findServiceById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveService(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(Service service) {
        serviceRepository.delete(service);
    }
}
