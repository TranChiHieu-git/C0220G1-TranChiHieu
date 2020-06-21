package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeproduct")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameTypeProduct;

    @OneToMany(mappedBy = "typeProduct")
    List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public TypeProduct() {
    }

    public TypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }
}
