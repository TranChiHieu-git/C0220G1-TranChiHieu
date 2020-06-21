package com.codegym.furama.model.admin.StaffModel.LevelModel;

import com.codegym.furama.model.admin.StaffModel.Staff;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLevel;
    private String nameLevel;
    @OneToMany(mappedBy = "level")
    public List<Staff> staff;


    public Level() {
    }

    public Level(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }
}
