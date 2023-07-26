import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { InscritComponent } from './inscrit/inscrit.component';
import { DhashboardAdminComponent } from './dhashboard-admin/dhashboard-admin.component';
import { ListUserAdminComponent } from './list-user-admin/list-user-admin.component';

const routes: Routes = [
  {path:'', redirectTo:'home' ,pathMatch:'full'},
  {path:'login' , component:LoginComponent},
  {path:'home' , component:MenuComponent} , 
  {path:'inscrit' , component:InscritComponent},
  {path:'admin' , component:DhashboardAdminComponent ,children :[
    {path:'listuser' , component:ListUserAdminComponent , outlet:'adminbody'}
    //{path:'addlivreur' , component:AddLivreurComponent, outlet:'adminbody'}
  ]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
