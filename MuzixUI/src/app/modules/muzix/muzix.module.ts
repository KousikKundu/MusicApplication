import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CardComponent } from './components/card/card.component';
import { CardContainerComponent } from './components/card-container/card-container.component';
import { AngularmaterialModule } from '../angularmaterial/angularmaterial.module';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

@NgModule({
  declarations: [CardComponent, CardContainerComponent, HeaderComponent, FooterComponent],
  imports: [
    CommonModule,
    AngularmaterialModule
  ],
  exports: [
    CardComponent,
    CardContainerComponent,
    HeaderComponent, 
    FooterComponent

  ]
})
export class MuzixModule { }
