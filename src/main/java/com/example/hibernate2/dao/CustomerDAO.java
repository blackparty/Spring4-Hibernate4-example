package com.example.hibernate2.dao;

import com.example.hibernate2.model.Customer;

import java.util.List;

/**
 * Created by MimiKuchiki on 16/5/2018.
 */


public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
    public boolean loginCustomer(Customer customer);
}
