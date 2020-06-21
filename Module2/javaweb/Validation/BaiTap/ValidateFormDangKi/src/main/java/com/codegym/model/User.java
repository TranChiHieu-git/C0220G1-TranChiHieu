package com.codegym.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Không thể bỏ trống")
    @Size(min = 1, max = 45, message = "Họ phải có ít nhất 1 kí tự và nhiều nhất 45 kí tự")
    @Pattern(regexp = "^[\\p{L}\\s]*$", message = "Tên chỉ được là chữ cái")
    private String firstName;
    @NotEmpty(message = "Không thể bỏ trống")
    @Size(min = 1, max = 45, message = "Tên phải có ít nhất 1 kí tự và nhiều nhất 45 kí tự")
    @Pattern(regexp = "^[\\p{L}\\s]*$", message = "Tên chỉ được là chữ cái")
    private String lastName;
    @NotEmpty(message = "Không thể bỏ trống")
    @Size(min = 5, max = 45, message = "Tài khoản phải có ít nhất 5 kí tự và nhiều nhất 45 kí tự")
    @Pattern(regexp = "^[A-Za-z0-9_]*$", message = "Tên tài khoản chỉ bao gồm chứ số và dấu _ ")
    private String account;
    @NotEmpty(message = "Không thể bỏ trống")
    @Size(min = 5, max = 45, message = "Mật khẩu phải có ít nhất 5 kí tự và nhiều nhất 45 kí tự")
    @Pattern(regexp = "^[A-Za-z0-9\\*\\@\\#]*$", message = "Mật khẩu chỉ bao gồm chứ số và dấu *@# ")
    private String password;
    @NotEmpty(message = "Không thể bỏ trống")
    @Size(min = 9, max = 11, message = "Số điện thoại phải có ít nhất 9 kí tự và nhiều nhất 11 kí tự")
    @Pattern(regexp = "^[0-9]*$", message = "Số điện thoại chỉ bao gồm chứ số")
    private String phoneNumber;
    @NotEmpty(message = "Không thể bỏ trống")
    @Range(min = 18, message = "Tuổi phải lớn hơn 18")
    @Pattern(regexp = "^[0-9]*$", message = "Tuổi chỉ bao gồm chứ số")
    private String age;
    @NotEmpty(message = "Không thể bỏ trống")
    @Pattern(regexp = "[a-zA-Z0-9\\_]{2,45}+\\@+[a-z]{3,8}+\\.+[a-z]{2,8}$", message = "Định dạng email không chính xác")
    private String email;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
