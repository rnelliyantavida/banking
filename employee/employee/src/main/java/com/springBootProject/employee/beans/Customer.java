package com.springBootProject.employee.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    long accNo;
    String firstName;
    String lastName;
    String address;
    int age;
    String occupation;
    Date birthDate;
    float balance;
    String lastTransaction;
}
