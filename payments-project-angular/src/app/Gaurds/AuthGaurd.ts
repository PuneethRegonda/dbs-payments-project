import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { Session } from "../services/session";

@Injectable({
    providedIn: 'root'
})
export class AuthGaurd implements CanActivate{
    constructor( private router: Router,private session:Session) {

    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
    :boolean{
        if(this.session.isauthenticated())
        return true;
        else this.router.navigate(['/login']);
        return false;

    }
}