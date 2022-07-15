package com.springBootProject.employee.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    long SSN;
    String firstName;
    String lastName;
    String address;
    int age;
    double salary;
    String bankLocation;
    String phoneNumber;

}
