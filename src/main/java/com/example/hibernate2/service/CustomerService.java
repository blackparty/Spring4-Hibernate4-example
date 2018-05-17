package com.example.hibernate2.service;

import com.example.hibernate2.model.Customer;

import java.util.List;

/**
 * Created by MimiKuchiki on 16/5/2018.
 */
public interface CustomerService {
    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    boolean login(Customer customer);
}
