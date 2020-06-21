package com.codegym.furama.model.user.bookService;

import javax.persistence.*;

public class OrderContract {

    private int id;
    private int idTypeService;
    private int idTypeRent;
    private String dateRent;
    private String dateEndRent;
    private int priceOfRent;


    public OrderContract(int idTypeService, int idTypeRent, String dateRent, String dateEndRent) {
        this.idTypeService = idTypeService;
        this.idTypeRent = idTypeRent;
        this.dateRent = dateRent;
        this.dateEndRent = dateEndRent;
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public int getIdTypeRent() {
        return idTypeRent;
    }

    public void setIdTypeRent(int idTypeRent) {
        this.idTypeRent = idTypeRent;
    }

    public OrderContract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDateRent() {
        return dateRent;
    }

    public void setDateRent(String dateRent) {
        this.dateRent = dateRent;
    }

    public String getDateEndRent() {
        return dateEndRent;
    }

    public void setDateEndRent(String dateEndRent) {
        this.dateEndRent = dateEndRent;
    }

    public int getPriceOfRent() {
        return priceOfRent;
    }

    public void setPriceOfRent(int priceOfRent) {
        this.priceOfRent = priceOfRent;
    }
}
