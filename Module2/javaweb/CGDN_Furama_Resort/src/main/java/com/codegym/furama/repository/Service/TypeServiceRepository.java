package com.codegym.furama.repository.Service;

import com.codegym.furama.model.admin.ServiceModel.TypeService.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeServiceRepository extends JpaRepository<TypeService, Integer> {
}
