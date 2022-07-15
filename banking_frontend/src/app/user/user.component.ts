import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from '../account.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [AccountService]
})
export class UserComponent implements OnInit {
  userForm: FormGroup;
  isValidAccountNumber = false;
  isWithdrawal = false;
  isDeposit = false;
  isTransaction = false;
  balance: any;
  userDetails: any = null;
  accountNumber: number;
  transactions: any;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute, private accountService: AccountService) { }

  ngOnInit(): void {
    this.userForm = new FormGroup({
      'accountNumber': new FormControl(null,Validators.required),
      'amount': new FormControl(null,Validators.required)
    });
 
  }
  onOk(){
    this.accountNumber = this.userForm.get('accountNumber').value;
    this.accountService.setAccountNumber(this.accountNumber);
    this.http.get('http://localhost:9191/customer/isvalid/'+this.accountNumber).subscribe(response => {
      if(response === 1){
        //console.log('valid');
        this.isValidAccountNumber = true;
        this.http.get('http://localhost:9191/customer/getCustomer/'+this.accountNumber).subscribe(response => {
          console.log(response);
          this.userDetails = response;
      });
      }else{
        alert("Account number is invalid");
        this.userForm.reset();
      }
    });
  }
    onWithdraw(){
      this.isDeposit = false;
      this.isTransaction = false;
      this.isWithdrawal = true;
    }
    withdraw(){
      this.http.get('http://localhost:9191/customer/withdraw/'+this.accountNumber+'/'+this.userForm.get('amount').value)
       .subscribe(response => {
         this.balance = response;
         if(this.balance === 0){
           alert('You don\'t have enough balance');
         }else{
           alert('your current balance is '+this.balance);
         }
       });
       this.isWithdrawal = false;
    }

    onDeposit(){
      this.isTransaction = false;
      this.isWithdrawal = false;
      this.isDeposit = true;
    }
    deposit(){
      this.http.get('http://localhost:9191/customer/deposit/'+this.accountNumber+'/'+this.userForm.get('amount').value)
       .subscribe(response => {
         this.balance = response;
         alert('your current balance is '+this.balance);
       });
       this.isDeposit = false;
    }

    transaction(){
      this.isDeposit = false;
      this.isWithdrawal = false;
      this.isTransaction = true;
      this.http.get('http://localhost:9191/customer/transactionDetails/'+this.accountNumber).subscribe(
        response => {
          this.transactions = response;
          //console.log(this.transactions);
        }
      )
    }
}
