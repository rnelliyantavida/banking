package com.springBootProject.customer.services;

import com.springBootProject.customer.beans.Account;
import com.springBootProject.customer.beans.Customer;
import com.springBootProject.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestTemplate restTemplate;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getByAccountNumber(long accNo) {
        return customerRepository.findById(accNo).get();
    }

    public double withdrawMoney(long accNo, float amount) {
        float balance = 0;
        Customer customer = customerRepository.findById(accNo).get();
        if(amount >= customer.getBalance()){
            return 0;
        }else {
            Account account = new Account(accNo,"withdraw",amount);
            restTemplate.postForObject("http://ACCOUNT-SERVICE/addTransaction",account,Account.class);
            balance = customer.getBalance() - amount;
            customer.setBalance(balance);
            customer.setLastTransaction("withdraw");
            customerRepository.save(customer);
        }
        return balance;
    }

    public double depositMoney(long accNo, float amount) {
        Account account = new Account(accNo,"deposit",amount);
        restTemplate.postForObject("http://ACCOUNT-SERVICE/addTransaction",account,Account.class);
        float balance = 0;
        Customer customer = customerRepository.findById(accNo).get();
        balance = customer.getBalance() + amount;
        customer.setBalance(balance);
        customer.setLastTransaction("deposit");
        customerRepository.save(customer);
        return balance;
    }

    public String balanceCheck(long accNo) {
        Customer customer = customerRepository.findById(accNo).get();
        return "Your balance is "+customer.getBalance();
    }

    public List transactionDetails(long accNo) {
        return restTemplate.getForObject("http://ACCOUNT-SERVICE/transactionDetails/"+accNo,List.class);
    }

    public int isValidAccountNumber(long accNo) {
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer: customers){
            if(customer.getAccNo() == accNo){
                return 1;
            }
        }
        return 0;
    }

}
