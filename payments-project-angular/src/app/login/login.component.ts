import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SessionService } from '../services/sessionService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  

  constructor(private router: Router,private sessionService: SessionService) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [
  
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
    console.log("Login init", this.username,this.password);
    this.router.navigate(['transfer']);
    this.sessionService.loginUser(this.username.value,this.password.value);
  }
  get username() {
    return this.loginForm.controls['username'];
  }
  get password() {
    return this.loginForm.controls['password'];
  }
  get isValid(){
    return this.loginForm.valid;
  }
}
