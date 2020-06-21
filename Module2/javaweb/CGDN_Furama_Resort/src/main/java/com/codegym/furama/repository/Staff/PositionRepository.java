package com.codegym.furama.repository.Staff;

import com.codegym.furama.model.admin.StaffModel.PositionModel.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
