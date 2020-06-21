package com.codegym.furama.service.Contract;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.Servicefollow.ServiceFollow;
import com.codegym.furama.repository.constract.ServiceFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceFollowServiceImpl implements serviceFollowService {
    @Autowired
    ServiceFollowRepository serviceFollowRepository;

    @Override
    public Iterable<ServiceFollow> findAllServiceFollow() {
        return serviceFollowRepository.findAll();
    }

    @Override
    public ServiceFollow findServiceFollowById(int id) {
        return serviceFollowRepository.findById(id).orElse(null);
    }
}
