package com.codegym.furama.repository.constract;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.ContractDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailsRepository extends JpaRepository<ContractDetails, Integer> {
    Iterable<ContractDetails> findAllByContract_Id(int id);

    Page<ContractDetails> findAllByContract_User_NameOrContract_Service_NameOrContract_Staff_NameOrderByIdContractDetails(String key1, String key2, String key3, Pageable pageable);
}
