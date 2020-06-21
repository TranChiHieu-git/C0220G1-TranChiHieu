package com.codegym.furama.repository.Staff;

import com.codegym.furama.model.admin.StaffModel.LevelModel.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {

}
