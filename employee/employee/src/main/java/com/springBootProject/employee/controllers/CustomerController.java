package com.springBootProject.employee.controllers;

import com.springBootProject.employee.beans.Customer;
import com.springBootProject.employee.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class CustomerController{
    @Autowired
    CustomerService customerService;

    @PostMapping("/addcustomer")
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return "Added Successfully";
    }

    @DeleteMapping("deletecustomer/{accNo}")
    public String deleteCustomer(@PathVariable long accNo){
        customerService.deleteCustomer(accNo);
        return "Deleted Successfully";
    }
}
