package com.codegym.furama.model.admin.validateContractDetails;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class validConDe {
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[0-9]{1,}$", message = "Số lượng phải là số nguyên dương")
    private String amountContractDetails;
    private int servicefollowId;
    private int contractId;

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public validConDe(String amountContractDetails) {
        this.amountContractDetails = amountContractDetails;
    }

    public String getAmountContractDetails() {
        return amountContractDetails;
    }

    public void setAmountContractDetails(String amountContractDetails) {
        this.amountContractDetails = amountContractDetails;
    }

    public int getServicefollowId() {
        return servicefollowId;
    }

    public void setServicefollowId(int servicefollowId) {
        this.servicefollowId = servicefollowId;
    }

    public validConDe() {
    }
}
