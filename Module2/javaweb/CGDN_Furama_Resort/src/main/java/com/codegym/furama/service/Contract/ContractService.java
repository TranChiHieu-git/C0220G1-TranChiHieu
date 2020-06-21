package com.codegym.furama.service.Contract;

import com.codegym.furama.model.admin.ContractModel.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    Page<Contract> findAllContract(Pageable pageable);
    Page<Contract> findAllContractOrderByName(Pageable pageable);



    Iterable<Contract> findAllContract();

    Page<Contract> findAllContractByName(String key, Pageable pageable);

    Contract findContractById(int id);

    void saveContract(Contract contract);

    void deleteContract(Contract contract);
}
