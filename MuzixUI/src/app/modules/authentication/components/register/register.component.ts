import { Component, OnInit } from '@angular/core';
import { User } from '../../User';
import { AuthenticationService } from 'src/app/modules/authentication/authentication.service';
import { MatSnackBar } from '@angular/material';
import { error } from 'util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  
  constructor(private authenticationService: AuthenticationService, 
    private matSanckBar: MatSnackBar, private router: Router) { 
    this.user= new User();
  }

  ngOnInit() {
    
  }
  
  register(){
    this.authenticationService.registerUser(this.user).subscribe( data=> {
      console.log('register data',this.user);
      if(data.status === 201) {
        this.matSanckBar.open("Successfully Registered", " ", {
          duration:1000
        });
        this.authenticationService.saveUser(this.user).subscribe( saveData => {
         console.log('saveData',saveData);
       });
        this.router.navigate(["/login"]);
      }
    },
    error => {
        console.log(error);
      }
    );
  }

}
