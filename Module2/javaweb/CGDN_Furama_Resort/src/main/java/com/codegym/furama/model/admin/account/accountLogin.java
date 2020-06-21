package com.codegym.furama.model.admin.account;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class accountLogin {
    @Size(min = 7, max = 100, message = "tài khoản phải bao ít nhất có 7 kí tự ")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[A-Za-z0-9\\-]{6,100}$", message = "tên tài khoản chỉ bao gồm chữ số và dấu -")
    String acc;
    @Size(min = 5, max = 100, message = "Mật khẩu phải ít nhất 5 kí tự ")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,100}$", message = "Mật khẩu bao gồm chữ và số")
    String pass;

    public accountLogin() {
    }

    public accountLogin(String acc, String pass) {
        this.acc = acc;
        this.pass = pass;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
