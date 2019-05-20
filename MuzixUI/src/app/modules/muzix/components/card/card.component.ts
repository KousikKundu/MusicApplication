import { Component, OnInit } from '@angular/core';
import { MuzixService } from '../../muzix.service';
import { Input } from '@angular/core';
import { Track } from 'src/app/modules/muzix/track';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

 
  @Input()
  track: Track ;

  constructor() {
    
   }

  ngOnInit() {
  }

}
