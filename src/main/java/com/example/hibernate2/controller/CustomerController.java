package com.example.hibernate2.controller;

import com.example.hibernate2.model.Customer;
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


}
