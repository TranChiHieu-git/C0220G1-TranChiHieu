package com.codegym.furama.model.admin.ServiceModel;

import com.codegym.furama.model.admin.ContractModel.Contract;
import com.codegym.furama.model.admin.ServiceModel.TypeRent.TypeRent;
import com.codegym.furama.model.admin.ServiceModel.TypeService.TypeService;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    public String id;
    public String name;
    public double area;
    public int numberOfFloor;
    public int numberOfMaxPeople;
    public int priceOfRent;
    private String status;
    @OneToMany(mappedBy = "service")
    public List<Contract> contract;

    @ManyToOne
    @JoinColumn(name = "typerent_idtyperent")
    public TypeRent typeRent;

    public TypeRent getTypeRent() {
        return this.typeRent;
    }

    public void setTypeRent(TypeRent typeRent) {
        this.typeRent = typeRent;
    }

    @ManyToOne
    @JoinColumn(name = "typeservice_idtyservice")
    public TypeService typeService;

    public TypeService getTypeService() {
        return this.typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public Service() {
    }

    public Service(String name, double area, int numberOfFloor, int numberOfMaxPeople, int priceOfRent,
                   String status, List<Contract> contract, TypeRent typeRent, TypeService typeService) {

        this.name = name;
        this.area = area;
        this.numberOfFloor = numberOfFloor;
        this.numberOfMaxPeople = numberOfMaxPeople;
        this.priceOfRent = priceOfRent;
        this.status = status;
        this.contract = contract;
        this.typeRent = typeRent;
        this.typeService = typeService;
    }

    public Service(String name, double area, int numberOfFloor, int numberOfMaxPeople, int priceOfRent, String status, TypeRent typeRent, TypeService typeService) {

        this.name = name;
        this.area = area;
        this.numberOfFloor = numberOfFloor;
        this.numberOfMaxPeople = numberOfMaxPeople;
        this.priceOfRent = priceOfRent;
        this.status = status;
        this.typeRent = typeRent;
        this.typeService = typeService;
    }

    public Service(String name, double area, int numberOfFloor, int numberOfMaxPeople, int priceOfRent, String status) {
        this.name = name;
        this.area = area;
        this.numberOfFloor = numberOfFloor;
        this.numberOfMaxPeople = numberOfMaxPeople;
        this.priceOfRent = priceOfRent;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public int getNumberOfMaxPeople() {
        return numberOfMaxPeople;
    }

    public void setNumberOfMaxPeople(int numberOfMaxPeople) {
        this.numberOfMaxPeople = numberOfMaxPeople;
    }

    public int getPriceOfRent() {
        return priceOfRent;
    }

    public void setPriceOfRent(int priceOfRent) {
        this.priceOfRent = priceOfRent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
