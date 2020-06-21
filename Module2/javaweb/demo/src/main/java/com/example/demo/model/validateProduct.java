package com.example.demo.model;

import javax.validation.constraints.*;
import java.util.Date;

public class validateProduct {
    int id;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s0-9]{1,}$", message = "Tên sản phẩm phải là chữ số và khoảng trắng. Không bao gồm kí tự đặc biệt")
    private String nameProduct;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{0,}$", message = "Giá phải nhập vào số dương")
    private String priceProduct;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{0,}$", message = "Số lượng phải nhập vào số dương")
    private String amountProdcut;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s0-9\\-\\.\\,]{0,}$", message = "Mô tả chỉ gồm chữ, số và kí tự -,.")
    private String descriptProduct;
    private int idTypeProdcut;

    public validateProduct(String nameProduct, String priceProduct, String amountProdcut, String descriptProduct, int idTypeProdcut) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amountProdcut = amountProdcut;
        this.descriptProduct = descriptProduct;
        this.idTypeProdcut = idTypeProdcut;
    }

    public validateProduct() {
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

    public int getIdTypeProdcut() {
        return idTypeProdcut;
    }

    public void setIdTypeProdcut(int idTypeProdcut) {
        this.idTypeProdcut = idTypeProdcut;
    }

}
