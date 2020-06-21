package com.codegym.furama.repository.constract;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.Servicefollow.ServiceFollow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceFollowRepository extends JpaRepository<ServiceFollow,Integer> {
}
