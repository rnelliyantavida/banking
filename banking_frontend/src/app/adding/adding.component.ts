import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Employee } from '../employee.model';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Customer } from '../customer.model';

@Component({
  selector: 'app-adding',
  templateUrl: './adding.component.html',
  styleUrls: ['./adding.component.css']
})
export class AddingComponent implements OnInit {
  employeeForm: FormGroup;
  ssn: number = null;
  employee: Employee = {
    ssn: null,
    firstName: '',
    lastName: '',
    address: '',
    age: null,
    salary: null,
    bankLocation: '',
    phoneNumber: ''
  }
  //employees: Employee[];
  customerForm: FormGroup;
  customer: Customer = {
    accNo: null,
    firstName: '',
    lastName: '',
    address: '',
    age: null,
    occupation: '',
    birthDate: null,
    balance: null,
    lastTransaction: ''
  };
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.employeeForm = new FormGroup({
      'firstName': new FormControl(null,Validators.required),
      'lastName': new FormControl(null,Validators.required),
      'address': new FormControl(null,Validators.required),
      'age': new FormControl(null,Validators.required),
      'salary': new FormControl(null,Validators.required),
      'bankLocation': new FormControl(null,Validators.required),
      'phoneNumber': new FormControl(null,Validators.required),
      'ssn': new FormControl(null,Validators.required)
    });

    this.customerForm = new FormGroup({
      'accNo': new FormControl(null,Validators.required),
      'firstName': new FormControl(null,Validators.required),
      'lastName': new FormControl(null,Validators.required),
      'address': new FormControl(null,Validators.required),
      'age': new FormControl(null,Validators.required),
      'occupation': new FormControl(null,Validators.required),
      'birthDate': new FormControl(null,Validators.required)
    });
    //this.http.get<Employee>('http://localhost:9191/employee/getemployee/2481242').subscribe(response => console.log(response));
  
    //this.http.delete('http://localhost:9191/customer/deletecustomer/6393158').subscribe(response => console.log(response));
  }
  onSaveEmployee(){
    this.employee.firstName = this.employeeForm.get('firstName').value;
    this.employee.lastName = this.employeeForm.get('lastName').value;
    this.employee.address = this.employeeForm.get('address').value;
    this.employee.age = this.employeeForm.get('age').value;
    this.employee.salary = this.employeeForm.get('salary').value;
    this.employee.bankLocation = this.employeeForm.get('bankLocation').value;
    this.employee.phoneNumber = this.employeeForm.get('phoneNumber').value;
    //console.log(this.employee);
    if(this.employee){
      this.http.post('http://localhost:7072/employee/addemployee',this.employee).subscribe((response: string) => console.log(response));
    }
    this.employeeForm.reset();
  }
  onDeleteEmployee(){
    this.ssn = this.employeeForm.get('ssn').value;
     if(this.ssn !== null){
      this.http.delete('http://localhost:7072/employee/deleteemployee/'+this.ssn).subscribe();
    }
    this.employeeForm.reset();
   }

   onSaveCustomer(){
     this.customer.firstName = this.customerForm.get('firstName').value;
     this.customer.lastName = this.customerForm.get('lastName').value;
     this.customer.address = this.customerForm.get('address').value;
     this.customer.age = this.customerForm.get('age').value;
     this.customer.occupation = this.customerForm.get('occupation').value;
     this.customer.birthDate = this.customerForm.get('birthDate').value;
     //console.log(this.customer);
     if(this.customer){
      this.http.post('http://localhost:7072/employee/addcustomer',this.customer).subscribe(response => console.log(response));
     }
     this.customerForm.reset();
   }
   onDeleteCustomer(){
     if(this.customerForm.get('accNo').value){
      this.http.delete('http://localhost:7072/employee/deletecustomer/'+this.customerForm.get('accNo').value).subscribe(response => console.log(response),
      (error: HttpErrorResponse) => console.log(error)
      );
     }
     this.customerForm.reset();
   }
}
