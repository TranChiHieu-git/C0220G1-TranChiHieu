package com.codegym.furama.model.admin.ServiceModel.TypeService;

import com.codegym.furama.model.admin.ServiceModel.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeservices")
public class TypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTypeService;
    private String nameTypeService;

    @OneToMany(mappedBy = "typeService")
    public List<Service> service;


    public TypeService() {
    }

    public TypeService(String nameTypeService) {
        this.nameTypeService = nameTypeService;
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getNameTypeService() {
        return nameTypeService;
    }

    public void setNameTypeService(String nameTypeService) {
        this.nameTypeService = nameTypeService;
    }
}
