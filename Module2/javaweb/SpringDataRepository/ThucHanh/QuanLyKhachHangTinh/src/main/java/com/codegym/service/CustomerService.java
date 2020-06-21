package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
