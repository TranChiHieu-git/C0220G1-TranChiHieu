package services;

import models.Customer;

import java.util.Map;

public interface CustomerService {
    void createCustomer(Customer customer);

    Map<Integer, Customer> showAllCustomer();

    Customer showCustomerByID(int id);

    Customer showCustomerByName(String name);

    void editCustomerByID(int id);

    void deleteCustomerByID(int id);
}
