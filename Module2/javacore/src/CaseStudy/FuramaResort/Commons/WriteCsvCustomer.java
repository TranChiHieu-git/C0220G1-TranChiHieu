package CaseStudy.FuramaResort.Commons;

import CaseStudy.FuramaResort.Models.Customer;

import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

public class WriteCsvCustomer {
    private static final String DAU_PHAY = ",";
    private static final String DONG_MOI = "\n";
    FileWriter fileCustomer = null;

    public void writeCsvCustomerFile(ArrayList<Customer> listCustomer) throws IOException {
        fileCustomer = new FileWriter("C:\\codegym\\CodeGym\\Module2\\C0220G1-TranChiHieu-Module2\\src\\CaseStudy\\FuramaResort\\Data\\Customer.csv");
        for (Customer customer : listCustomer) {
            fileCustomer.append(customer.getName());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getBirthday());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getSex());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getCMND());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getNumberPhone());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getEmail());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getTypeOfCustomer());
            fileCustomer.append(DAU_PHAY);
            fileCustomer.append(customer.getAddress());
            fileCustomer.append(DONG_MOI);
            fileCustomer.flush();
        }
    }

    public void ext() {
        try {
            fileCustomer.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
