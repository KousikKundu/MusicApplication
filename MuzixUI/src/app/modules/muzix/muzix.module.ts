import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardComponent } from './components/card/card.component';
import { CardContainerComponent } from './components/card-container/card-container.component';
import { AngularmaterialModule } from '../angularmaterial/angularmaterial.module';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { DialogComponent } from './components/dialog/dialog.component';
import { PlayListComponent } from './components/play-list/play-list.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { InterceptorService } from './interceptor.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { MuzixService } from 'src/app/modules/muzix/muzix.service';



@NgModule({
  declarations: [CardComponent, CardContainerComponent, HeaderComponent, FooterComponent, DialogComponent, PlayListComponent],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AngularmaterialModule
  ],
  exports: [
    CardComponent,
    CardContainerComponent,
    HeaderComponent, 
    AppRoutingModule,
    FooterComponent

  ],
  providers: [
    MuzixService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorService,
      multi: true
    }
  ],
  entryComponents: [
    DialogComponent
  ]
})
export class MuzixModule { }
