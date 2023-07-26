import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';
import { Observable } from 'rxjs';
import { User } from '../model/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_OF_API = "http://localhost:8899/extrairedata";
  requetHeader = new HttpHeaders(
    {"No-Auth":"True"}
  )
  TOKEN = this.userAuthService.getToken();

    headers = new HttpHeaders(
    {"Authorization": `Bearer ${this.TOKEN}`}
    )

  constructor(private httpClient:HttpClient , private userAuthService : UserAuthService ) { }

  public login(loginData : any){
    return this.httpClient.post(this.PATH_OF_API+"/authenticate" , loginData , {headers : this.requetHeader})
  }

  //////////////////////////////////CRUD Client //////////////////////////////////////// 
  
  //Creation Client 
  createClient(client: User): Observable<Object>{
    return this.httpClient.post(`${this.PATH_OF_API}/registerNewUser`, client);
  }


  getUserByuserName(userName : string ) : Observable<User>{
   
    return  this.httpClient.get<User>(`${this.PATH_OF_API}/getUserByuserName/${userName}`, {headers :this.headers} );

  }

  

  //////////////////////////////////END CRUD Client ////////////////////////////////////////
  //////////////////////////////////CRUD Livreur ////////////////////////////////////////
  createLivreur(Livreur: User): Observable<Object>{
    return this.httpClient.post(`${this.PATH_OF_API}/registerNewLivreur`, Livreur);
  }
  
    //////////////////////////////////END CRUD Livreur ////////////////////////////////////////

  //Affiche TOUt USER 
  getAllUser(): Observable<User[]>{
    
    return this.httpClient.get<User[]>(`${this.PATH_OF_API}/allUser` , {headers :this.headers});
  }

  //Delete user
  deleteUser(id : string):Observable<object>{
    return this.httpClient.delete(`${this.PATH_OF_API}/user/${id}`);
 }
  //update user
  updateUser (id : string , user:User) : Observable<Object> {
    return this.httpClient.put(`${this.PATH_OF_API}/user/${id}` , user);
  }

  //change  user password 
  changePasswordUser (id : string , user:User) : Observable<Object> {
    return this.httpClient.put(`${this.PATH_OF_API}/userNewPassword/${id}` , user);
  }

 /* //Get User by id 
  getUserByUserName(userName : string): Observable<User>{
    
    return this.httpClient.get<User>(`${this.PATH_OF_API}/user/${userName}`);
  }*/

  //get match message 
  public matchPass(rawPass : string ,encodedPass : string ){
    return this.httpClient.get(`${this.PATH_OF_API}/MatchedPass/${rawPass}/${encodedPass}` , {responseType : 'text'});
  }



     




//mta3 video 
public forAdmin(){
  return this.httpClient.get(this.PATH_OF_API + '/forAdmin' , {responseType : 'text'});
}
public forClient(){
  return this.httpClient.get(this.PATH_OF_API + '/forClient' , {responseType : 'text'});
}



/// second no work 

  public roleMatche(allowedRole : any): boolean {
    let isMatch = false;
    
    const userRoles : any =this.userAuthService.getRoles();
    if(userRoles[0] != 'NO_ROLE' && userRoles){
      for(const element of userRoles){
        for(let alloRole of allowedRole){
          console.log(alloRole);
          if(element.roleName === alloRole){
            isMatch=true ;
            return isMatch ;
          }
          
        }
         
      }
    }
      return isMatch ;
    
  }

}
