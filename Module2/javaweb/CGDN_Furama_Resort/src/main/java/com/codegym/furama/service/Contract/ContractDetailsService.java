package com.codegym.furama.service.Contract;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.ContractDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailsService {
    Page<ContractDetails> findAllContractDetails(Pageable pageable);

    Iterable<ContractDetails> findAllContractDetails();

    Iterable<ContractDetails> findAllContractDetailsByName(int id);

    Page<ContractDetails> findAllContractDetailsByName(String key, Pageable pageable);

    ContractDetails findContractDetailsById(int id);

    void saveContractDetails(ContractDetails contractDetails);

    void deleteContractDetails(int id);

}
