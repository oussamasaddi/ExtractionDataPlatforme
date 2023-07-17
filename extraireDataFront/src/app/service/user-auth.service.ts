import { Injectable } from '@angular/core';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setCurrentUser(user : User){
    localStorage.setItem('currentUser',JSON.stringify(user));

  }

  public getCurrentUser () : User{

    const user = new User();
    console.log(JSON.parse(this.getMessage(localStorage.getItem('currentUser') || JSON.stringify(user))))
    return JSON.parse(this.getMessage(localStorage.getItem('currentUser') || JSON.stringify(user)));
  }

  public setRoles(role:[]){
    localStorage.setItem('roles',JSON.stringify(role));
  }


  getMessage(message: string) : string{
    return message;
  }


  public getRoles(): [] {
    return JSON.parse(this.getMessage(localStorage.getItem('roles') || JSON.stringify(['NO_ROLE'])));
  }
  public setToken(jwtToken : string){
    localStorage.setItem('jwtToken' , jwtToken);
  }

  public getToken() : string { 
    return this.getMessage(localStorage.getItem('jwtToken')|| '');
  }

  public clear(){
    localStorage.clear();
  }

  public isLoggedIn() {
    
    //(this.getRoles()!= '')&&(
    if(this.getToken() !=""){
      return true ;
    }

    //return this.getRoles() && this.getToken() ;
    return false ;

  }
}
