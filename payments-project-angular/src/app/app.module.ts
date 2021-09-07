import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TransferComponent } from './transfer/transfer.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    TransferComponent,
  ],
  imports: [   
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    RouterModule.forRoot([
    {
      path:'login', component:LoginComponent
    },
    {
      path:"dashboard",component:DashboardComponent
    },
    {
      path:"transfer",component:TransferComponent
    },
    {
      path:"logout",component:LoginComponent
    },

    {
      path:"",component:LoginComponent
    },
    
  
  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
