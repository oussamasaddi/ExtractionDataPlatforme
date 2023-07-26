import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthService } from '../service/user-auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor( private router:Router , 
    private userAuthService : UserAuthService
    ) { }

  ngOnInit(): void {
    console.log(this.userAuthService.getCurrentUser())
  }
   GoLogin(){
    this.router.navigate(['login']);
  }

}
