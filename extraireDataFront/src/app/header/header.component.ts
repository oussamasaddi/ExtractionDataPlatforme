import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userName : string="";

  constructor(private userAuthService:UserAuthService , private router : Router , 
    private userService : UserService
    
    ) { }

  ngOnInit(): void {
    this.userName = this.userAuthService.getCurrentUser().userName;
  }

  public isLoggedIn(){

    return this.userAuthService.isLoggedIn();
  }



  public isLivreur(role : any) : boolean{

    return this.userService.roleMatche(role);
  }

  

  public isLogout(){
    this.userAuthService.clear();
    this.router.navigate(["/home"]);
  }

}
