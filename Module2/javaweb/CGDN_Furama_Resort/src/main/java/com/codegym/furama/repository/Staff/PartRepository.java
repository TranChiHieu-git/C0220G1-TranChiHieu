package com.codegym.furama.repository.Staff;

import com.codegym.furama.model.admin.StaffModel.PartModel.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Integer> {
}
