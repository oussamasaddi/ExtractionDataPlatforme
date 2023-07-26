import { Component, OnInit } from '@angular/core';
//import Swal from 'sweetalert2';
import { User } from '../model/user';
import { UserAuthService } from '../service/user-auth.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user : User = new User();
  currentUserName : string ="";
  constructor(private userAuthservice : UserAuthService , 
      private userService : UserService 
    ) { }

  ngOnInit(): void {
    this.currentUserName=this.userAuthservice.getCurrentUser().userName ;
    this.user = this.userAuthservice.getCurrentUser();
  }

  onSubmit(){
    this.userService.updateUser(this.currentUserName ,this.user).subscribe(data =>{
    //  Swal.fire('Change Profil', 'You changed your profile informations succesfully!', 'success');
      this.userAuthservice.setCurrentUser(this.user);

    });

  }

}
