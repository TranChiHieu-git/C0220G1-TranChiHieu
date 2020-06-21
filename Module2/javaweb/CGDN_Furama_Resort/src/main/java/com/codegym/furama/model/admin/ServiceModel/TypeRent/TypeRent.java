package com.codegym.furama.model.admin.ServiceModel.TypeRent;

import com.codegym.furama.model.admin.ServiceModel.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typerents")
public class TypeRent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTypeRent;
    private String nameTypeRent;
    private int priceTypeRent;
    @OneToMany(mappedBy = "typeRent")
    public List<Service> service;

    public TypeRent() {
    }

    public TypeRent(String nameTypeRent, int priceTypeRent) {
        this.nameTypeRent = nameTypeRent;
        this.priceTypeRent = priceTypeRent;
    }

    public int getIdTypeRent() {
        return idTypeRent;
    }

    public void setIdTypeRent(int idTypeRent) {
        this.idTypeRent = idTypeRent;
    }

    public String getNameTypeRent() {
        return nameTypeRent;
    }

    public void setNameTypeRent(String nameTypeRent) {
        this.nameTypeRent = nameTypeRent;
    }

    public int getPriceTypeRent() {
        return priceTypeRent;
    }

    public void setPriceTypeRent(int priceTypeRent) {
        this.priceTypeRent = priceTypeRent;
    }
}
