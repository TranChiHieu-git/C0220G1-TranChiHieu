package com.codegym.furama.service.Contract;

import com.codegym.furama.model.admin.ContractModel.Contract;
import com.codegym.furama.repository.constract.ConstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ConstractRepository constractRepository;

    @Override
    public Page<Contract> findAllContractOrderByName(Pageable pageable) {
        return constractRepository.findAllUserHaeContract(pageable);
    }

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return constractRepository.findAll(pageable);
    }

    @Override
    public Iterable<Contract> findAllContract() {
        return constractRepository.findAll();
    }

    @Override
    public Page<Contract> findAllContractByName(String key, Pageable pageable) {
        return constractRepository.findAllByStaff_NameContainingOrUser_NameOrService_NameOrderById(key, key, key, pageable);
    }

    @Override
    public Contract findContractById(int id) {
        return constractRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContract(Contract contract) {
        constractRepository.save(contract);
    }

    @Override
    public void deleteContract(Contract contract) {
        constractRepository.delete(contract);
    }
}
