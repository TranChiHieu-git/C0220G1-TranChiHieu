package com.codegym.furama.model.admin.UserModel;

import com.codegym.furama.model.admin.ContractModel.Contract;
import com.codegym.furama.model.admin.UserModel.TypeUserModel.TypeUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;

    private String name;
    private String dayOfBirth;
    private String numberOfCMND;
    private String numberPhone;
    private String email;
    private String address;

    @OneToMany(mappedBy = "user")
    public List<Contract> contract;

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }

    @ManyToOne
    @JoinColumn(name = "typeuser_idtypeuser")
    public TypeUser typeUser;

    public TypeUser getTypeUser() {
        return this.typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public User() {
    }

    public User(String name, String dayOfBirth, String numberOfCMND, String numberPhone, String email, String address, TypeUser typeUser) {

        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.numberOfCMND = numberOfCMND;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.typeUser = typeUser;
    }

    public User(String id, String name, String dayOfBirth, String numberOfCMND, String numberPhone, String email, String address, List<Contract> contract, TypeUser typeUser) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.numberOfCMND = numberOfCMND;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.contract = contract;
        this.typeUser = typeUser;
    }

    public User(String name, String dayOfBirth, String numberOfCMND, String numberPhone, String email, String address) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.numberOfCMND = numberOfCMND;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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


}

