import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class MuzixService {

  thirdPartyApi: string;
  apiKey: string;

  constructor(private httpClient : HttpClient) {

    this.thirdPartyApi = 'http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=';
    this.apiKey = '&api_key=b5e020e920cb3b98d015d975d5e4fa76&format=json';

   }

   getAllMuzixTrack(country: string): Observable<any> {
    const url = `${this.thirdPartyApi}${country}${this.apiKey}`;
    console.log(url);
     return this.httpClient.get(url);
  }


}
