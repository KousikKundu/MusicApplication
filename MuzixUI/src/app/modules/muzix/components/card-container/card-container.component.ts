import { Component, OnInit } from '@angular/core';
import { MuzixService } from 'src/app/modules/muzix/muzix.service';
import {Track} from './../../track';
import { Artist } from 'src/app/modules/muzix/artist';
import { Image } from 'src/app/modules/muzix/image';
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
  serachTracks: Array<Track>;

  constructor(private muszixService: MuzixService) { 
    this.country = 'India';
    this.tracks = [];
  }

  ngOnInit() {

    this.muszixService.getAllMuzixTrack(this.country).subscribe(tracks => {
      console.log(tracks);

      const data = tracks['tracks']['track'];
      data.forEach(tragetdata => {
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
        //this.tarckObj.trackId = this.country.slice(0, 3) + this.id;
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
  

}
