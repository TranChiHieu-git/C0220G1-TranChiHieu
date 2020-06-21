package com.codegym.furama.model.admin.validateUser;

import com.codegym.furama.model.admin.validateStaff.birthdayAnnotation;

import javax.validation.constraints.*;

public class validateUser {
    @NotEmpty(message = "Không được để trống")
    @Size(min = 2, max = 100, message = "Tên phải ít nhất có 2 kí tự")
    @Pattern(regexp = "^[\\p{L}\\s]{2,100}$", message = "Tên khách hàng chỉ bao gồm chữ và dấu cách")
    private String name;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{4}+\\-+[0-9]{2}+\\-+[0-9]{2}$", message = "Ngày sinh phải theo định dạng yyyy-mm-dd")
    @birthdayAnnotation
    private String dayOfBirth;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{11})$", message = "số CMND phải có 9 hoặc 11 số")
    private String numberOfCMND;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+90)+[0-9]{7}$", message = "Số điện thoại phải theo định dạng" +
            " 090xxxxxxx hoặc 091xxxxxxx " +
            "hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String numberPhone;
    @ExistEmail
    @Pattern(regexp = "^[a-zA-z0-9]{5,50}+\\@+[a-z]{3,8}+\\.+[a-z]{2,6}$", message = "Địa chỉ email phải đúng định dạng email")
    @NotEmpty(message = "Không được để trống")
    private String email;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s0-9\\/\\-]{5,150}$", message = "Địa chỉ chỉ bao gồm chữ, số dấu / và -")
    private String address;
    private int idTypeUser;

    public validateUser() {
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getNumberOfCMND() {
        return numberOfCMND;
    }

    public void setNumberOfCMND(String numberOfCMND) {
        this.numberOfCMND = numberOfCMND;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(int idTypeUser) {
        this.idTypeUser = idTypeUser;
    }
}
