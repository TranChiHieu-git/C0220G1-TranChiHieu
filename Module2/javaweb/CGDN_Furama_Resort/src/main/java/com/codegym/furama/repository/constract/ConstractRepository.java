package com.codegym.furama.repository.constract;

import com.codegym.furama.model.admin.ContractModel.Contract;
import com.codegym.furama.model.admin.UserModel.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConstractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByStaff_NameContainingOrUser_NameOrService_NameOrderById(String key1, String key2, String key3,
                                                                                   Pageable pageable);

    @Query("select c from Contract c where c.endContractDate >= current_date group by c.user.name")
    Page<Contract> findAllUserHaeContract(Pageable pageable);
}
