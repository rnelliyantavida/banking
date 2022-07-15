package com.springBootProject.customer.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    long accNo;
    String lastTransaction;
    float amount;
    //Date transactionDate;
}
