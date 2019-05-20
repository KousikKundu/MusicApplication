import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CardContainerComponent } from 'src/app/modules/muzix/components/card-container/card-container.component';
import { RegisterComponent } from 'src/app/modules/authentication/components/register/register.component';
import { LoginComponent } from 'src/app/modules/authentication/components/login/login.component';

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
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
