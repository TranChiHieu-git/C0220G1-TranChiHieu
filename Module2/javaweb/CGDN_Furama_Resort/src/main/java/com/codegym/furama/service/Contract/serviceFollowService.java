package com.codegym.furama.service.Contract;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.Servicefollow.ServiceFollow;

public interface serviceFollowService {
    Iterable<ServiceFollow> findAllServiceFollow();

    ServiceFollow findServiceFollowById(int id);
}
