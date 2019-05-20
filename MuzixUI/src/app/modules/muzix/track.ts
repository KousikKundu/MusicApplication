import { Artist } from 'src/app/modules/muzix/artist';

export class Track {
  trackId: string;
  name: string;
  listeners: string;
  url: string;
  comments: string;
  artist: Artist;
}
