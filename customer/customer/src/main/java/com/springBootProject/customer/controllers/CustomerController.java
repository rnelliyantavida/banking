package com.springBootProject.customer.controllers;

import com.springBootProject.customer.beans.Account;
import com.springBootProject.customer.beans.Customer;
import com.springBootProject.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("isvalid/{accNo}")
    public int isValidAccountNumber(@PathVariable long accNo){
        return customerService.isValidAccountNumber(accNo);
    }

    @GetMapping("/getCustomers")
    public List<Customer>  getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/getCustomer/{accNo}")
    public Customer getByAccountNumber(@PathVariable long accNo){
        return customerService.getByAccountNumber(accNo);
    }

    @GetMapping("withdraw/{accNo}/{amount}")
    public double withdrawMoney(@PathVariable long accNo, @PathVariable float amount){
        return customerService.withdrawMoney(accNo,amount);
    }

    @GetMapping("deposit/{accNo}/{amount}")
    public double depositMoney(@PathVariable long accNo, @PathVariable float amount){
        return customerService.depositMoney(accNo,amount);
    }

    @GetMapping("balance/{accNo}")
    public String balanceCheck(@PathVariable long accNo){
        return customerService.balanceCheck(accNo);
    }

    @GetMapping("transactionDetails/{accNo}")
    public List transactionDetails(@PathVariable long accNo){
        return customerService.transactionDetails(accNo);
    }

}
