package com.codegym.furama.service.Staff;

import com.codegym.furama.model.admin.StaffModel.PositionModel.Position;

public interface PositionService {
    Iterable<Position> findAllPos();

    Position findPosById(int id);
}
