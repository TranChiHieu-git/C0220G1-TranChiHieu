package com.codegym.furama.model.admin.validateStaff;

import javax.validation.constraints.*;


public class staffValid {
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s]{6,100}$", message = "Tên chỉ bao gồm chữ và khoảng trống")
    @Size(min = 6, max = 100, message = "Tên có ít nhất 6 kí tự")
    public String name;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{4}+\\-+[0-9]{2}+\\-+[0-9]{2}$", message = "Ngày sinh phải theo định dạng yyyy-mm-dd")
    @birthdayAnnotation
    public String dayOfBirth;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{11})$", message = "số CMND phải có 9 hoặc 11 số")
    public String numberOfCMND;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{4,50}$", message = "Lương chỉ bao gồm số")
    @salaryAnnotation
    public String salary;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+90)+[0-9]{7}$", message = "Số điện thoại phải theo định dạng" +
            " 090xxxxxxx hoặc 091xxxxxxx " +
            "hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    public String numberPhone;
    @Pattern(regexp = "^[a-zA-z0-9]{5,50}+\\@+[a-z]{3,8}+\\.+[a-z]{2,6}$", message = "Địa chỉ email phải đúng định dạng email")
    @NotEmpty(message = "Không được để trống")
    @emailExistAnnotation
    public String email;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[\\p{L}\\s0-9\\/\\-]{5,150}$", message = "Địa chỉ chỉ bao gồm chữ, số dấu / và -")
    public String address;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(admin|staff)+\\-+[a-z]{5,50}$", message = "tên tài khoản phải bắt đầu là admin( đối với quản lý) hoặc staff(đối với nhân viên)")
    @accountExistAnnotation
    public String account;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,100}$", message = "Mật khẩu bao gồm chữ và số")
    public String password;

    public int idLevel;

    public int idPart;

    public int idPosition;

    public staffValid() {
    }

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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }
}
