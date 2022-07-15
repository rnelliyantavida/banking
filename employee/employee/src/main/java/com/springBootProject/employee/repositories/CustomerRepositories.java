package com.springBootProject.employee.repositories;

import com.springBootProject.employee.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositories extends JpaRepository<Customer,Long> {
}
