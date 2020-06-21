package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String nameProduct;
    public String priceProduct;
    public String amountProdcut;
    public String descriptProduct;
    public Date dateCreate;
    @ManyToOne
    @JoinColumn(name = "typeproduct_id")
    TypeProduct typeProduct;

    public Product(String nameProduct, String priceProduct, String amountProdcut, String descriptProduct,  TypeProduct typeProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amountProdcut = amountProdcut;
        this.descriptProduct = descriptProduct;
        this.typeProduct = typeProduct;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Product() {
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getAmountProdcut() {
        return amountProdcut;
    }

    public void setAmountProdcut(String amountProdcut) {
        this.amountProdcut = amountProdcut;
    }

    public String getDescriptProduct() {
        return descriptProduct;
    }

    public void setDescriptProduct(String descriptProduct) {
        this.descriptProduct = descriptProduct;
    }
}
