import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { response } from 'express';
import { AuthServiceService } from '../service/auth-service.service';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = "";
  password: string;
  message : string ; 
  
  auth : {"userName":string , "userPassword" :string};
  
   
  constructor(private authService : AuthServiceService , private router : Router , 
    private userService : UserService,
    private userAuthService : UserAuthService) {
    
   }

  ngOnInit(): void {
    
  }

  handleLogin() {
    this.email="oussama";
    this.password="admin";
    this.authService.login(this.email, this.password).subscribe((result) => {
  
      this.message = 'Login Successful';
      // redirect to main page
    }, () => {
      this.message = 'Login not Allowed ';
    });
  }
  doLogin(){
   // let resp =this.authService.login2(this.email , this.password);
    //resp.subscribe(data=>{
      //console.log(data);
      //this.router.navigate(["/home"]);
    //})
    
    
    
    
  }
  login(){
    
    this.userService.login(this.auth).subscribe(
      (response:any)=>{
        console.log(response.jwtToken);
        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);
        //test set and get current user
        this.userAuthService.setCurrentUser(response.user);
        //end test
        const role = response.user.role[0].roleName;
        if(role=="Admin"){
          this.router.navigate(['/admin']);
        }else{
          this.router.navigate(['/home']);

        }
      },
      (error) =>{
        console.log(error);
      }
    )
  }
}
