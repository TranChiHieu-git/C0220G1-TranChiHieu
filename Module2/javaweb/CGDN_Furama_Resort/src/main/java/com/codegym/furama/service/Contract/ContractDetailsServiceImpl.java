package com.codegym.furama.service.Contract;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.ContractDetails;
import com.codegym.furama.repository.constract.ContractDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailsServiceImpl implements ContractDetailsService {
    @Autowired
    ContractDetailsRepository contractDetailsRepository;

    @Override
    public Page<ContractDetails> findAllContractDetails(Pageable pageable) {
        return contractDetailsRepository.findAll(pageable);
    }

    @Override
    public Iterable<ContractDetails> findAllContractDetails() {
        return contractDetailsRepository.findAll();
    }

    @Override
    public Iterable<ContractDetails> findAllContractDetailsByName(int id) {
        return contractDetailsRepository.findAllByContract_Id(id);
    }

    @Override
    public Page<ContractDetails> findAllContractDetailsByName(String key, Pageable pageable) {
        return contractDetailsRepository.findAllByContract_User_NameOrContract_Service_NameOrContract_Staff_NameOrderByIdContractDetails(key, key, key, pageable);
    }

    @Override
    public ContractDetails findContractDetailsById(int id) {
        return contractDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContractDetails(ContractDetails contractDetails) {
        contractDetailsRepository.save(contractDetails);
    }

    @Override
    public void deleteContractDetails(int id) {
        contractDetailsRepository.deleteById(id);
    }
}
