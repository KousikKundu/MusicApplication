import { Component, OnInit } from '@angular/core';
import { Track } from 'src/app/modules/muzix/track';
import { Input, Output, EventEmitter } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { DialogComponent } from 'src/app/modules/muzix/components/dialog/dialog.component';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  wishData: boolean;

  @Input()
  track: Track ;

  @Output()
  addtowishList = new EventEmitter ();

  @Output()
  deleteFromwishList = new EventEmitter ();

  @Output()
  updateComments = new EventEmitter ();


  constructor(public dialog: MatDialog) {
    
   }

  ngOnInit() {
  }

  addMyTrack(track) {
    console.log('card comp' , track);
    this.addtowishList.emit(track);
  }

  deleteTrack(track) {
    this.deleteFromwishList.emit(track);
  }

  addComments() {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: {comments: this.track.comments}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.track.comments = result;
      this.updateComments.emit(this.track);
    });

  }

}
