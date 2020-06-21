package com.codegym.furama.repository.Staff;


import com.codegym.furama.model.admin.StaffModel.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findByAccountAndPassword(String acc, String pass);

    Page<Staff> findAllByNameContainingOrPart_NamePartOrPosition_NamePositionOrAddressOrderById(String name, String part, String pos, String address, Pageable pageable);
}
