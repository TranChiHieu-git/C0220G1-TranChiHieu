package com.codegym.furama.service.Staff;

import com.codegym.furama.model.admin.StaffModel.PositionModel.Position;
import com.codegym.furama.repository.Staff.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAllPos() {
        return positionRepository.findAll();
    }

    @Override
    public Position findPosById(int id) {
        return positionRepository.findById(id).orElse(null);
    }
}
