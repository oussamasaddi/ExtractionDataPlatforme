import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-user-admin',
  templateUrl: './list-user-admin.component.html',
  styleUrls: ['./list-user-admin.component.css']
})
export class ListUserAdminComponent implements OnInit {
  users : User[];

  constructor(private userService : UserService) { }

  
  ngOnInit(): void {
    this.getAllUser();
  }

  private getAllUser(){
   
    this.userService.getAllUser().subscribe(data => {
      this.users = data ;

      console.log(data[0].role[0].roleName);
      
    });
  }
  
  deleteUser(id : string){

    Swal.fire({
      title: 'Are you sure want to remove?',
      text: 'You will not be able to recover this file!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it',
    }).then((result) => {
      if (result.value) {
        this.deleteuserFinal(id);
        Swal.fire(
          'Deleted!',
          'Your imaginary file has been deleted.',
          'success'
        );
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire('Cancelled', 'Your imaginary file is safe :)', 'error');
      }
    });


   
  }
  private deleteuserFinal(id :string){
    this.userService.deleteUser(id).subscribe(data => {
      console.log(data);
      this.getAllUser();
    });
  }

}
