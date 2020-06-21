package com.codegym.furama.model.admin.ContractModel;

import com.codegym.furama.model.admin.ContractModel.ContractDetails.ContractDetails;
import com.codegym.furama.model.admin.ServiceModel.Service;
import com.codegym.furama.model.admin.StaffModel.Staff;
import com.codegym.furama.model.admin.UserModel.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String contractDate;

    private String endContractDate;

    private int deposit;
    public int totalCost = 0;

    public Contract(String contractDate, String endContractDate, int deposit, Service service, Staff staff, User user) {
        this.contractDate = contractDate;
        this.endContractDate = endContractDate;
        this.deposit = deposit;
        this.service = service;
        this.staff = staff;
        this.user = user;
    }

    public List<ContractDetails> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetails> contractDetails) {
        this.contractDetails = contractDetails;
    }

    @OneToMany(mappedBy = "contract")
    public List<ContractDetails> contractDetails;

    @ManyToOne
    @JoinColumn(name = "service_id")
    public Service service;

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @ManyToOne
    @JoinColumn(name = "staff_id")
    public Staff staff;

    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contract() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getEndContractDate() {
        return endContractDate;
    }

    public void setEndContractDate(String endContractDate) {
        this.endContractDate = endContractDate;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int setTotalCost() {
        this.totalCost = 0;
        String[] contractdate = contractDate.split("-");
        String[] endcontractdate = endContractDate.split("-");
        int day = Integer.parseInt(contractdate[2]);
        int month = Integer.parseInt(contractdate[1]);
        int year = Integer.parseInt(contractdate[0]);
        int day2 = Integer.parseInt(endcontractdate[2]);
        int month2 = Integer.parseInt(endcontractdate[1]);
        int year2 = Integer.parseInt(endcontractdate[0]);
        Date date1 = new Date(year, month, day);
        Date date2 = new Date(year2, month2, day2);
        int time = ((int) (date2.getTime() - date1.getTime())) / 86400000;
        if (time == 0) {
            time = 1;
        } else {
            time++;
        }
        int moneyOfServiceFollow = 0;
        if (contractDetails != null) {
            for (int i = 0; i < contractDetails.size(); i++) {
                moneyOfServiceFollow += contractDetails.get(i).getServiceFollow().getPerServiceFollow() * contractDetails.get(i).getAmountContractDetails();
            }
        }
        this.totalCost = (moneyOfServiceFollow + (service.getPriceOfRent() * time)) - this.deposit;
        return moneyOfServiceFollow;
    }
}
