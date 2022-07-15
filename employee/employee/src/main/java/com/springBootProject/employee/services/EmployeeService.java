package com.springBootProject.employee.services;

import com.springBootProject.employee.beans.Employee;
import com.springBootProject.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(long ssn) {
        return employeeRepository.findById(ssn).get();
    }

    public void deleteEmployee(long ssn) {
        employeeRepository.deleteById(ssn);
    }
}
