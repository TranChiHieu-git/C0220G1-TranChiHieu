package com.codegym.furama.service.Staff;

import com.codegym.furama.model.admin.StaffModel.Staff;
import com.codegym.furama.repository.Staff.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;

    @Override
    public Staff findAcc(String acc, String pass) {
        return staffRepository.findByAccountAndPassword(acc, pass);
    }

    @Override
    public Staff findStaffById(int id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Staff staff) {
        staffRepository.delete(staff);
    }

    @Override
    public Page<Staff> findAllStaff(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Page<Staff> findStaffByName(String key, Pageable pageable) {
        return staffRepository.findAllByNameContainingOrPart_NamePartOrPosition_NamePositionOrAddressOrderById(key, key, key, key, pageable);
    }

    @Override
    public Iterable<Staff> findAllStaff() {
        return staffRepository.findAll();
    }


}
