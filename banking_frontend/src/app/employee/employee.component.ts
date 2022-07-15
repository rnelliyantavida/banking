import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employeeForm: FormGroup;
  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.employeeForm = new FormGroup({
      'userName': new FormControl(null,[Validators.required,this.userNameValidate.bind(this)]),
      'password': new FormControl(null,[Validators.required,this.passwordValidate.bind(this)])
    })
  }
  onSubmit(){
    this.router.navigate(['/adding']);
  }
  userNameValidate(control: FormControl): {[s: string]: boolean} {
    if(control.value !== 'bank'){
      return {IsuserName: true}
    }
    return null;
  }
  passwordValidate(control: FormControl): {[s: string]: boolean}{
    if(control.value !== 'password'){
      return {IsPassword: true}
    }
    return null;
  }
}
