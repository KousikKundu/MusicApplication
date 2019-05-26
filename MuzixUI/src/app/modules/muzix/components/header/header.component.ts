import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/modules/authentication/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthenticationService, private route: Router) { }

  ngOnInit() {
  }

  logout() {
    this.authService.logout();
    console.log('loggin out');
    this.route.navigate(["/login"]);
   }

}
