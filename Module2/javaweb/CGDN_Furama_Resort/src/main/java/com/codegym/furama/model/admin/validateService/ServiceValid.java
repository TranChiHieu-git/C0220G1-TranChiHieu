package com.codegym.furama.model.admin.validateService;

import javax.validation.constraints.*;

public class ServiceValid {

    @UniqueName
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(Villa - |House - |Room - )+[\\p{L}\\s]{1,100}$",
            message = "Tên dịch vụ phải theo định dạng TênDịchvụ - XXXXX(ví dụ: Villa - Thuê Theo Ngày)")
    private String name;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{0,}+\\.+[0-9]{1,}$",
            message = "Diện tích sử dụng phải lớn hơn 0 và có dạng 0.0")
    private String area;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{0,}$",
            message = "Số tầng phải là số nguyên dương và lớn hơn 0")
    private String numberOfFloor;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{0,}$",
            message = "Số người tối đa là số nguyên dương và lớn hơn 0")
    private String numberOfMaxPeople;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{3,}$",
            message = "Số tiền thuê là số nguyên dương và lớn hơn 1000")
    private String priceOfRent;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s]{1,}$",
            message = "Trạng thái chỉ bao gồm kí tự")
    private String status;
    private int idTypeTent;
    private int idTypeService;

    public ServiceValid() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getNumberOfMaxPeople() {
        return numberOfMaxPeople;
    }

    public void setNumberOfMaxPeople(String numberOfMaxPeople) {
        this.numberOfMaxPeople = numberOfMaxPeople;
    }

    public String getPriceOfRent() {
        return priceOfRent;
    }

    public void setPriceOfRent(String priceOfRent) {
        this.priceOfRent = priceOfRent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTypeTent() {
        return idTypeTent;
    }

    public void setIdTypeTent(int idTypeTent) {
        this.idTypeTent = idTypeTent;
    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }
}
