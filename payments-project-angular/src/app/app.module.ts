import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TransferComponent } from './transfer/transfer.component';
import { HeaderComponent } from './header/header.component';
import { NavitemsComponent } from './navitems/navitems.component';
import { TransactionHistoryComponent } from './transaction-history/transaction-history.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SessionService } from './services/sessionService';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TransferComponent,
    HeaderComponent,
    NavitemsComponent,
    TransactionHistoryComponent,
    PagenotfoundComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    RouterModule.forRoot([
      {
        path: 'login', component: LoginComponent
      },
    
      {
        path: "transfer", component: TransferComponent
      },
      {
        path: "logout", redirectTo:"login"
      },
      {
        path: "transactions", component: TransactionHistoryComponent
      },
      {
        path: "", component: LoginComponent
      },
      {
        path: "**", redirectTo:"page-not-found"
      },
      {path:"page-not-found",component:PagenotfoundComponent}

    ])
  ],
  providers: [SessionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
