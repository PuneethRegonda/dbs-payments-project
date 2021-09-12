import { Component } from '@angular/core';
import { NavigationStart, Router } from '@angular/router';
import { AuthService } from './services/authService';
import { Session } from './services/session';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'payments-project';

  constructor(private session :Session, private sessionService: AuthService, router: Router) {
    // on route change to '/login', set the variable showHead to false
    // router.navigateByUrl("")
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
    return this.session.isLoggedIn;
  }

}