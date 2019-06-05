import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardContainerComponent } from 'src/app/modules/muzix/components/card-container/card-container.component';
import { RegisterComponent } from 'src/app/modules/authentication/components/register/register.component';
import { LoginComponent } from 'src/app/modules/authentication/components/login/login.component';
import {PlayListComponent} from 'src/app/modules/muzix/components/play-list/play-list.component';

import { AuthGuardService } from 'src/app/modules/muzix/auth-guard.service';
import { RecommendedComponent } from 'src/app/modules/muzix/components/recommended/recommended.component';

const routes: Routes = [

  {
    path: '' ,
    component: LoginComponent,
  },
  {
    path: 'login' ,
    component: LoginComponent,
  },
  {
    path: 'register' ,
    component: RegisterComponent,
  },
  {
    path: 'home' ,
    component: CardContainerComponent,
  },

  {
    path: 'wishList' ,
    component: PlayListComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'recommendedList' ,
    component: RecommendedComponent,
    canActivate: [AuthGuardService]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
