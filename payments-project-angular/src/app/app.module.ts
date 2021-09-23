import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TransferComponent } from './transfer/transfer.component';
import { HeaderComponent } from './header/header.component';
import { NavitemsComponent } from './navitems/navitems.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AuthService } from './services/authService';
import { MessagesServices } from './services/messagecodes.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DataService } from './services/dataservice';
import { TransferService } from './services/transfer.service';
import { EmployeeLoginComponent } from './employee-login/employee-login.component';
import { Session } from './services/session';
import { AuthGaurd } from './Gaurds/AuthGaurd';
import { DialogComponent } from './dialog/dialog.component';
import { ToastrModule } from 'ngx-toastr';
import { NotificationService } from './notification.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TransferComponent,
    HeaderComponent,
    NavitemsComponent,
    PagenotfoundComponent,
    EmployeeLoginComponent,
    DialogComponent,

  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    RouterModule.forRoot([
      {
        path: 'login', component: LoginComponent,
      },
    
      {
        path: "transfer", component: TransferComponent, canActivate: [AuthGaurd]
      },
      {
        path: "logout", redirectTo:""
      },
      {
        path: "employee-login", component:EmployeeLoginComponent
      },
      {
        path: "", component: LoginComponent
      },

      {
        path: "**", redirectTo:"page-not-found"
      },

    ]),
    BrowserAnimationsModule
    
  ],
  providers: [Session,AuthService,MessagesServices,DataService,TransferService,NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
