package com.springBootProject.employee.services;

import com.springBootProject.employee.beans.Customer;
import com.springBootProject.employee.repositories.CustomerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositories customerRepositories;

    public void addCustomer(Customer customer) {
        //customer.setBalance(0);
        //customer.setLastTransaction(null);
        customerRepositories.save(customer);
    }

    public void deleteCustomer(long accNo) {
        customerRepositories.deleteById(accNo);
    }
}
