package com.codegym.furama.model.user.reviewUser;

import com.codegym.furama.model.user.accountUserNormal.accountUserNormal;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String review;

    @ManyToOne
    @JoinColumn(name = "typeserviceuserorder_id")
    public TypeServiceUserOrder typeServiceUserOrder;

    public TypeServiceUserOrder getTypeServiceUserOrder() {
        return typeServiceUserOrder;
    }

    public void setTypeServiceUserOrder(TypeServiceUserOrder typeServiceUserOrder) {
        this.typeServiceUserOrder = typeServiceUserOrder;
    }

    @ManyToOne
    @JoinColumn(name = "accountusernormal_id")
    public accountUserNormal accountUserNormal;

    public com.codegym.furama.model.user.accountUserNormal.accountUserNormal getAccountUserNormal() {
        return accountUserNormal;
    }

    public void setAccountUserNormal(com.codegym.furama.model.user.accountUserNormal.accountUserNormal accountUserNormal) {
        this.accountUserNormal = accountUserNormal;
    }

    public Review() {
    }

    public Review(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
