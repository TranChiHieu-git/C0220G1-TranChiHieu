package com.codegym.furama.model.user.accountUserNormal;

import com.codegym.furama.model.user.bookService.OrderContract;
import com.codegym.furama.model.user.reviewUser.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accountusernormal")
public class accountUserNormal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String dayOfBirth;
    public String numberOfCMND;
    public String numberPhone;
    public String email;
    public String address;
    public String account;
    public String password;

    @OneToMany(mappedBy = "accountUserNormal")
    List<Review> reviewList;

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public accountUserNormal() {
    }

    public accountUserNormal(String name, String dayOfBirth, String numberOfCMND, String numberPhone, String email,
                             String address, String account, String password) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.numberOfCMND = numberOfCMND;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
