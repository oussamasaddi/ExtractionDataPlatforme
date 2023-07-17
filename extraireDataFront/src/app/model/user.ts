import { Role } from "./role";
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
@NgModule({
    imports: [
      FormsModule
    ],
    // 
})
export class User {
    userName : string ;
    userEmail: string | undefined;
    userFirstName: string | undefined;
    userLastName: string | undefined;
    userPhoneNumber: number | undefined;
    userEtats: string | undefined;
    userCin: string | undefined;
    userPassword: string | undefined;
    role : Role[]  ;

}
