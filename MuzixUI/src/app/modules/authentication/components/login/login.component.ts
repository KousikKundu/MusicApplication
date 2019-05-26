import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/modules/authentication/User';
import { AuthenticationService } from 'src/app/modules/authentication/authentication.service';
import { MatSnackBar } from '@angular/material';
import { Router } from '@angular/router';
export const TOKEN_NAME= "jwt_token";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  constructor(private authService: AuthenticationService, 
  private matSnackBar: MatSnackBar,private router: Router) { }

  ngOnInit() {
    this.user = new User();
  }

  login() {
    this.authService.loginUser(this.user).subscribe( data =>{
      console.log(data);
      if(data){
        console.log('token coming', data.body["token"]);
        localStorage.setItem(TOKEN_NAME, data.body["token"]);
        this.matSnackBar.open(data.body["message"], " ", {
          duration:1000
        });
        this.router.navigate(["/home"]);
      }
    },
    error =>{
      console.log('error', error);
      if(error.status === 404 ){
        this.matSnackBar.open(error.error.message, " ", {
          duration:1000
        });
      }
    }
  );
  }

}
