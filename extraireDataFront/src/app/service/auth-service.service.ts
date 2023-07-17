import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
public username : string ;
public password : string ;
  constructor(private httpClient : HttpClient) { }

  login(username : string , password : string){
    return this.httpClient.get(  `${environment.hostUrl}/api/v1/login`,
      { headers: { authorization: this.createBasicAuthToken(username, password) } }).pipe(map((res) => {
        this.username = username;
        this.password = password;
        this.registerSuccessfulLogin(username, password);
      }));
  }
 
  createBasicAuthToken(username : string , password : string){
    return 'Basic' + window.btoa(username+":"+password)
  }
  registerSuccessfulLogin(username : string, password :string ){
    //save to session
  }
  /////////////////////////// 2 eme methode 
  public login2(username:string , password : string){

    const headers = new HttpHeaders({Authorization :'Basic '+btoa(username+":"+password)});
    return this.httpClient.get("http://localhost:8898/api/v1/login" , {headers,responseType:'text' as 'json'});

  }
  getUsers() {
    let username='oussama'
    let password='admin'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
   return  this.httpClient.get("http://localhost:8898/api/v1/User",{headers});
  }
}
