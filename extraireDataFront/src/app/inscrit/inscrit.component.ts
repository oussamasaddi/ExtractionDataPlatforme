import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-inscrit',
  templateUrl: './inscrit.component.html',
  styleUrls: ['./inscrit.component.css']
})
export class InscritComponent implements OnInit {
client : User = new User();
  constructor(private userService : UserService , 
    private router : Router
    ) { }

  ngOnInit(): void {
    
  }

  CreateClient(){
    this.userService.createClient(this.client).subscribe( data =>{
      console.log(data);
      this.router.navigate(['/login']);
      
    },
    error => console.log(error));
  }

  onSubmit(){
    
    console.log(this.client);
    this.CreateClient();
  }
  goHome(){
    this.router.navigate(['/home']);
  }

}
