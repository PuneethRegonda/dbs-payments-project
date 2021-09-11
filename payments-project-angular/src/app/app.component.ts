import { Component } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { SessionService } from './services/sessionService';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payments-project';
  
  constructor(private sessionService: SessionService, router: Router) {
    // on route change to '/login', set the variable showHead to false
    router.events.forEach((event) => {
      if (event instanceof NavigationStart) {
        console.log(event.url);
         if (event.url == '/logout') {
          this.sessionService.logout();
        }
      }
    });
  }

  get isLogedIn() {
    return this.sessionService.isLoggedIn;
  }

}