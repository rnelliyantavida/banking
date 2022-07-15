package com.springBootProject.accountTransaction.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Account {
    @Id

    int accId;
    long accNo;
    String lastTransaction;
    float amount;
    LocalDate transactionDate;
}
