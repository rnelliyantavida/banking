package com.springBootProject.employee.controllers;

import com.springBootProject.employee.beans.Employee;
import com.springBootProject.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("addemployee")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Added Successfully";
    }
    @GetMapping("getemployee/{ssn}")
    public Employee getEmployee(@PathVariable long ssn){
        return employeeService.getEmployee(ssn);
    }

    @DeleteMapping("deleteemployee/{ssn}")
    public String deleteEmployee(@PathVariable long ssn){
        employeeService.deleteEmployee(ssn);
        return "Deleted Successfully";
    }

}
