package com.codegym.furama.model.admin.validateContract;

import com.codegym.furama.model.admin.validateStaff.birthdayAnnotation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@dateMakeContractValidate
public class validateContract {
    @Pattern(regexp = "^[0-9]{4}+\\-+[0-9]{2}+\\-+[0-9]{2}$", message = "Ngày làm hợp đồng phải theo định dạng yyyy-mm-dd")
    @NotEmpty(message = "Không được để trống")
    @birthdayAnnotation
    public String contractDate;
    @Pattern(regexp = "^[0-9]{4}+\\-+[0-9]{2}+\\-+[0-9]{2}$", message = "Ngày kết thúc phải theo định dạng yyyy-MM-dd")
    @NotEmpty(message = "Không được để trống")
    @birthdayAnnotation
    public String endContractDate;
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[1-9]{1}+[0-9]{3,100}$", message = "Tiền cộc phải là số nguyên dương và lớn hơn 0")
    public String deposit;
    public String serviceId;
    public String staffId;
    public String userId;

    public validateContract() {
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

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
