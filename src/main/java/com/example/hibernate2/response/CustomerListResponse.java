package com.example.hibernate2.response;

import com.example.hibernate2.model.Customer;

import java.util.List;

/**
 * Created by MimiKuchiki on 17/5/2018.
 */
public class CustomerListResponse {
    private SystemResponse systemResponse;
    private List<Customer> customers;

    public CustomerListResponse() {
    }

    public CustomerListResponse(SystemResponse systemResponse, List<Customer> customers) {
        this.systemResponse = systemResponse;
        this.customers = customers;
    }

    public SystemResponse getSystemResponse() {
        return systemResponse;
    }

    public void setSystemResponse(SystemResponse systemResponse) {
        this.systemResponse = systemResponse;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
