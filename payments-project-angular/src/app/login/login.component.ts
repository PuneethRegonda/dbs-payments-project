import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/authService';
import { Session } from '../services/session';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;



  constructor(private router: Router, private sessionService: AuthService, private session :Session) {
    this.loginForm = new FormGroup({
      userid: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(14),
        // Validators.pattern(/^[a-z0-9]+$/i)
      ]),
      password: new FormControl('', [

        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(25),
        // Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,10}$/)
      ])
    });
  }

  ngOnInit(): void {
  }

  handleLogin() {
    console.log("Login init", this.userid, this.password);
    this.sessionService.loginUser(
      { userid: +this.userid?.value, password: this.password?.value })
      .subscribe((result: any) => {
        console.log(result);
        if(result.status){
          this.session.isLoggedIn = true;
          this.session.setSessionUser(result?.data)
          console.log(this.session.getSessionUser);
          this.router.navigate(['transfer']);
        }
      },err=>{
        console.log(err); 
        alert(err);
      }
      
      );
  }
  get userid() {
    return this.loginForm.controls['userid'];
  }
  get password() {
    return this.loginForm.controls['password'];
  }
  get isValid() {
    return this.loginForm.valid;
  }
}
