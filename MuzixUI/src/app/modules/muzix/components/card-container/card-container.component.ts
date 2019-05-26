import { Component, OnInit } from '@angular/core';
import { MuzixService } from 'src/app/modules/muzix/muzix.service';
import {Track} from './../../track';
import { Artist } from 'src/app/modules/muzix/artist';
import { Image } from 'src/app/modules/muzix/image';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.css']
})
export class CardContainerComponent implements OnInit {
  country: string;
  tarckObj: Track;
  artistObj: Artist;
  imageObj: Image;
  tracks: Track[];
  artistName: string;
  statusCode: number;
  errorStatus: string;
  serachTracks: Array<Track>;
  id: number;

  constructor(
    private muszixService: MuzixService,
    private routes: ActivatedRoute,
    private matSnackBar: MatSnackBar) {
    this.country = 'India';
    this.tracks = [];
  }

  ngOnInit() {

    this.muszixService.getAllMuzixTrack(this.country).subscribe(tracks => {
      console.log(tracks);
      this.id = 0;
      const data = tracks['tracks']['track'];
      data.forEach(tragetdata => {
        this.id ++ ;
        this.tarckObj = new Track();
        this.artistObj = new Artist();
        this.imageObj = new Image();
        this.artistObj = tragetdata['artist'];
        this.imageObj.text = tragetdata['image'][2]['#text'];
        this.imageObj.size = tragetdata['image'][2]['#size'];
        this.tarckObj = tragetdata;
        this.tarckObj.artist = this.artistObj;
        this.artistObj.image = this.imageObj;
        this.tracks.push(this.tarckObj);
        this.tarckObj.trackId = this.country.slice(0, 3) + this.id;
        this.serachTracks = this.tracks;
      });
    });
  }

  oneKey(event: any) {
    this.artistName = event.target.value;
    const result = this.serachTracks.filter(track => {
      return track.artist.name.match(this.artistName);
    });
    this.tracks = result;
  }

  addtowishList(track) {
    console.log('Conatiner track', track);
    this.muszixService.addTrackToPlayList(track).subscribe (
      data => {
        console.log(data);
        this.statusCode = data.status;
        if (this.statusCode === 201) {
          this.matSnackBar.open('Track Successfully added !!!', ' ', {
            duration: 1000
          });
        }
      },
      error => {
        this.errorStatus = `${error.status}`;
        const errorMsg = `${error.error.message}`;
        console.log('erro msg', errorMsg ,'errorStatus' , this.errorStatus);
       this.statusCode = parseInt(this.errorStatus, 10);
       console.log('statusCode' , this.statusCode);
        if (this.statusCode === 409) {
          this.matSnackBar.open(errorMsg, '', {
            duration: 1000
          });
          this.statusCode = 0;
        }

      }

    );

  }
  

}
