package com.codegym.furama.model.admin.StaffModel;

import com.codegym.furama.model.admin.StaffModel.LevelModel.Level;
import com.codegym.furama.model.admin.StaffModel.PartModel.Part;
import com.codegym.furama.model.admin.StaffModel.PositionModel.Position;

import javax.persistence.*;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String dayOfBirth;
    public String numberOfCMND;
    public String salary;
    public String numberPhone;
    public String email;
    public String address;
    public String account;
    public String password;

    public Staff(String name, String dayOfBirth, String numberOfCMND, String salary, String numberPhone, String email, String address, String account, String password, Position position, Part part, Level level) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.numberOfCMND = numberOfCMND;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.password = password;
        this.position = position;
        this.part = part;
        this.level = level;
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

    @ManyToOne
    @JoinColumn(name = "position_idposition")
    public Position position;

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "part_idpart")
    public Part part;

    public Part getPart() {
        return this.part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    @ManyToOne
    @JoinColumn(name = "level_idlevel")
    public Level level;

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Staff() {
    }

    public Staff(String name, String dayOfBirth, String numberOfCMND, String salary, String numberPhone, String email, String address) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.numberOfCMND = numberOfCMND;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
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
}
