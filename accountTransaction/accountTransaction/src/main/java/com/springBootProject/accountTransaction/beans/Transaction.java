package com.springBootProject.accountTransaction.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    String lastTransaction;
    float amount;
    LocalDate transactionDate;
}
