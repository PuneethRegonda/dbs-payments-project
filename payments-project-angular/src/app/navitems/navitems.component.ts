import { Component } from '@angular/core';
import { Session } from '../services/session';

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
        text: "Logout",
        link: "logout"
      }
    ]
   
  };



}
