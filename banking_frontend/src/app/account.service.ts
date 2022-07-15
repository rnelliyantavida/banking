//import { Subject } from "rxjs";
//import { EventEmitter } from "stream";

import { EventEmitter } from "@angular/core";

export class AccountService{
    accountNumber: number;
    setAccountNumber(accountNumber: number){
        this.accountNumber = accountNumber;
        //console.log(this.accountNumber);
    }
    getAccountNumber(){
        return this.accountNumber;
    }
}