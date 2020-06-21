package com.codegym.furama.model.admin.StaffModel.PositionModel;

import com.codegym.furama.model.admin.StaffModel.Staff;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPosition;
    private String namePosition;

    @OneToMany(mappedBy = "position")
    public List<Staff> staff;


    public Position() {
    }

    public Position(String namePosition) {
        this.namePosition = namePosition;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}
