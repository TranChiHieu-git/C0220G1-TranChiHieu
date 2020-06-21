package com.codegym.furama.model.user.reviewUser;

import com.codegym.furama.model.user.bookService.OrderContract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeserviceuserorder")
public class TypeServiceUserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameService;

    @OneToMany(mappedBy = "typeServiceUserOrder")
    public List<Review> review;

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public TypeServiceUserOrder(String nameService) {
        this.nameService = nameService;
    }

    public TypeServiceUserOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }
}
