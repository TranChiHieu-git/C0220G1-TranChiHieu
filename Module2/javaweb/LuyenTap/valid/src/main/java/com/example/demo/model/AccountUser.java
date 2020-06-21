package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualFields
public class AccountUser {
    @Size(min = 10, max = 100, message = "tài khoản phải có ít nhất 10 kí tự và nhiều nhất 100 kí tự")
    @Pattern(regexp = "^(staff|admin)+\\-+[a-zA-Z-0-9]{5,100}$", message = "Tài khoản nhân viên phải có dạng staff-xxxxx, chỉ bao gồm chữ và số")
    @NotEmpty(message = "tài khoản không thể bỏ trống")
    String acc;
    @Size(min = 5, max = 100, message = "Mật khẩu phải có ít nhất 5 kí tự và nhiều nhất 100 kí tự")
    @Pattern(regexp = "^[a-zA-Z-0-9]{5,}$", message = "Mật khẩu phải là chữ hoặc số")
    @NotEmpty(message = "mật khẩu không thể bỏ trống")
    String pass;

    @NotEmpty(message = "Không được bỏ trống")
    String checkpass;

    public AccountUser() {
    }

    public AccountUser(String acc, String pass) {
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

    public String getCheckpass() {
        return checkpass;
    }

    public void setCheckpass(String checkpass) {
        this.checkpass = checkpass;
    }
}
