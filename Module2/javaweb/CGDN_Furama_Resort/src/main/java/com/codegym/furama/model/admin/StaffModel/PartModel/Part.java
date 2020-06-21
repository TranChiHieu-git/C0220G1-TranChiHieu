package com.codegym.furama.model.admin.StaffModel.PartModel;

import com.codegym.furama.model.admin.StaffModel.Staff;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPart;
    private String namePart;
    @OneToMany(mappedBy = "part")
    public List<Staff> staff;

    public Part() {
    }

    public Part(String namePart) {
        this.namePart = namePart;
    }

    public int getIdPart() {
        return idPart;
    }

    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }

    public String getNamePart() {
        return namePart;
    }

    public void setNamePart(String namePart) {
        this.namePart = namePart;
    }
}
