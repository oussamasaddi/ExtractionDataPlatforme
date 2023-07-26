import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { Client } from '../model/client';
import { User } from '../model/user';
//import { ClientService } from '../service/client.service';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-dhashboard-admin',
  templateUrl: './dhashboard-admin.component.html',
  styleUrls: [
    './dhashboard-admin.component.css' ,
    "./Back/css/custom.css",
    "./Back/css/font.css",
    "./Back/css/style.default.css" ,
    "./Back/css/widget.css" ,
    "./Back/vendor/bootstrap/css/bootstrap.min.css" ,
    "./Back/vendor/font-awesome/css/font-awesome.min.css" 
    
]

})
export class DhashboardAdminComponent implements OnInit {
 // clients : Client[];
  users : User[];
  message :string = "";
  
//clients : any;
  
  constructor( private router : Router ,
     private userAuthService : UserAuthService , 
     private userService : UserService
     ) { 
    
  }

  ngOnInit(): void {
   
    this.getAllUser();
   // this.forAdmin();
  }
  private getClients(){
   

  }
  private getAllUser(){
   
    this.userService.getAllUser().subscribe(data => {
      this.users = data ;
      console.log(data);
      
    });
  }


 /* forAdmin(){
    this.userService.forAdmin().subscribe(
      (response) => {
        console.log(response);
        this.message = response ;
      },
      (error) => {
        console.log(error);
      }
    );
  }*/

  public isLogout(){
    this.userAuthService.clear();
    //this.router.navigate(["/home"]);
  }



}
