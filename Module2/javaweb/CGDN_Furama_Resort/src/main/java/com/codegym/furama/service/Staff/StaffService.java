package com.codegym.furama.service.Staff;


import com.codegym.furama.model.admin.StaffModel.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {
    Staff findAcc(String acc, String pass);

    Staff findStaffById(int id);

    void saveStaff(Staff staff);

    void deleteStaff(Staff staff);

    Page<Staff> findAllStaff(Pageable pageable);

    Page<Staff> findStaffByName(String key, Pageable pageable);
    Iterable<Staff> findAllStaff();
}
