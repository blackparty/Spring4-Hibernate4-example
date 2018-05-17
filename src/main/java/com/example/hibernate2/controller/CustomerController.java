package com.example.hibernate2.controller;

import com.example.hibernate2.model.Customer;
import com.example.hibernate2.response.CustomerListResponse;
import com.example.hibernate2.response.SystemResponse;
import com.example.hibernate2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by MimiKuchiki on 17/5/2018.
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/addCustomer",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SystemResponse addCustomer(
            @RequestBody Customer customer
    ){
        customerService.saveCustomer(customer);
        return new SystemResponse(true,customer.getFirstname()+" is added succesfully.");
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SystemResponse login(Customer user){
        SystemResponse systemResponse = new SystemResponse();
        systemResponse.setFlag(customerService.login(user));
        if(systemResponse.isFlag()){
            systemResponse.setMessage(user.getUsername()+" is logged in successfully.");
        }else{
            systemResponse.setMessage("wrong username or password");
        }
        return systemResponse;
    }

    @RequestMapping(value = "/customerList",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomerListResponse getCustomers(){
        CustomerListResponse clr = new CustomerListResponse();

        //fetching all customers found on the database.
        clr.setCustomers(customerService.getCustomers());

        //assuming all transactions are successful.
        SystemResponse systemResponse = new SystemResponse(true,"Fetching all the customers are successful.");
        clr.setSystemResponse(systemResponse);

        return clr;
    }

}
