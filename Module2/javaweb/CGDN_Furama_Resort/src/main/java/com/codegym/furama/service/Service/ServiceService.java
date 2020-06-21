package com.codegym.furama.service.Service;

import com.codegym.furama.model.admin.ServiceModel.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAllService(Pageable pageable);
    Page<Service> findAllServiceByName(String key,Pageable pageable);
    Iterable<Service> findAllService();
    Service findServiceById(String id);

    void saveService(Service service);

    void deleteService(Service service);
}
