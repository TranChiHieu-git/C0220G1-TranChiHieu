package com.codegym.furama.service.Staff;

import com.codegym.furama.model.admin.StaffModel.PartModel.Part;
import com.codegym.furama.repository.Staff.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    PartRepository partRepository;

    @Override
    public Iterable<Part> findAllPart() {
        return partRepository.findAll();
    }

    @Override
    public Part findPartById(int id) {
        return partRepository.findById(id).orElse(null);
    }
}
