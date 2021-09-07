import { Component } from '@angular/core';

@Component({
  selector: 'app-navitems',
  templateUrl: './navitems.component.html',
  styleUrls: ['./navitems.component.css']
})
export class NavitemsComponent {
  
  navitems: Array<any>
  currentDate:any;
  price='1000';
  phone= '1234567890';
  countryList :any;
  country:any;
  cartTotal:any;
  constructor() {
    
    this.navitems = [
    {
      text: "Transfer",
      link: "transfer"
    },
    {
      text: "My Transactions",
      link: "transactions"
    },
    {
      text: "Logout",
      link: "logout"
    },
  ]
  };



}
