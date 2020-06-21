package com.codegym.furama.service.Staff;

import com.codegym.furama.model.admin.StaffModel.LevelModel.Level;

public interface LevelService {
    Iterable<Level> findAllLevel();
    Level findLevelById(int id);
}
