package com.codegym.furama.model.admin.ContractModel.ContractDetails.Servicefollow;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.ContractDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "servicefollows")
public class ServiceFollow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idServiceFollow;
    private String nameServiceFollow;
    private int priceServiceFollow;
    private int perServiceFollow;
    private String statusUse;

    @OneToMany(mappedBy = "serviceFollow")
    public List<ContractDetails> contractDetails;

    public ServiceFollow() {
    }

    public ServiceFollow(String nameServiceFollow, int priceServiceFollow, int perServiceFollow, String statusUse) {
        this.nameServiceFollow = nameServiceFollow;
        this.priceServiceFollow = priceServiceFollow;
        this.perServiceFollow = perServiceFollow;
        this.statusUse = statusUse;
    }

    public int getIdServiceFollow() {
        return idServiceFollow;
    }

    public void setIdServiceFollow(int idServiceFollow) {
        this.idServiceFollow = idServiceFollow;
    }

    public String getNameServiceFollow() {
        return nameServiceFollow;
    }

    public void setNameServiceFollow(String nameServiceFollow) {
        this.nameServiceFollow = nameServiceFollow;
    }

    public int getPriceServiceFollow() {
        return priceServiceFollow;
    }

    public void setPriceServiceFollow(int priceServiceFollow) {
        this.priceServiceFollow = priceServiceFollow;
    }

    public int getPerServiceFollow() {
        return perServiceFollow;
    }

    public void setPerServiceFollow(int perServiceFollow) {
        this.perServiceFollow = perServiceFollow;
    }

    public String getStatusUse() {
        return statusUse;
    }

    public void setStatusUse(String statusUse) {
        this.statusUse = statusUse;
    }
}
