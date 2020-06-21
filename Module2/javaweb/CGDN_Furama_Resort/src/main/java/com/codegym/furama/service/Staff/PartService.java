package com.codegym.furama.service.Staff;

import com.codegym.furama.model.admin.StaffModel.PartModel.Part;

public interface PartService {
    Iterable<Part> findAllPart();

    Part findPartById(int id);
}
