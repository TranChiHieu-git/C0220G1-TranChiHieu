package com.codegym.furama.repository.Service;

import com.codegym.furama.model.admin.ServiceModel.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, String> {
    Page<Service> findAllByNameContainingOrTypeRent_NameTypeRentOrTypeService_NameTypeServiceOrStatusOrderById(String key, String key2, String key3,
                                                                                                               String key4, Pageable pageable);
}
