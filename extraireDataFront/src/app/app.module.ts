import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { ProfileComponent } from './profile/profile.component';
import { InscritComponent } from './inscrit/inscrit.component';
import { DhashboardAdminComponent } from './dhashboard-admin/dhashboard-admin.component';
import { ListUserAdminComponent } from './list-user-admin/list-user-admin.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    LoginComponent,
    HeaderComponent,
    ProfileComponent,
    InscritComponent,
    DhashboardAdminComponent,
    ListUserAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule , 
    FormsModule , 
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
