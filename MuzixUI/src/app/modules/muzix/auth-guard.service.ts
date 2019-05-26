import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router/src/interfaces';
import { AuthenticationService } from '../authentication/authentication.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private authService: AuthenticationService, private router: Router) { }

  canActivate() {
    if(this.authService.isTokenExpired()){
      console.log('Inside Canactivate');
      return true;
    }
    console.log('Outside Canactivate');
    this.router.navigate(["/login"]);
    return false;
  }
}
