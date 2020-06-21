package com.codegym.furama.repository.Service;

import com.codegym.furama.model.admin.ServiceModel.TypeRent.TypeRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRentRepository extends JpaRepository<TypeRent, Integer> {
}
