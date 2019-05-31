package com.stackroute.rabbitmq.domain;

import com.stackroute.muzixmanager.model.Artist;

public class TrackDTO {


  private String trackId;
  private String trackNamne;
  private String trackUrl;
  private String trackListeners;
  private String comments;
  private ArtistDTO artist;

  public TrackDTO() {
  }

  public TrackDTO(String trackId, String trackNamne, String trackUrl, String trackListeners, String comments, ArtistDTO artist) {
    this.trackId = trackId;
    this.trackNamne = trackNamne;
    this.trackUrl = trackUrl;
    this.trackListeners = trackListeners;
    this.comments = comments;
    this.artist = artist;
  }

  public String getTrackId() {
    return trackId;
  }

  public void setTrackId(String trackId) {
    this.trackId = trackId;
  }

  public String getTrackNamne() {
    return trackNamne;
  }

  public void setTrackNamne(String trackNamne) {
    this.trackNamne = trackNamne;
  }

  public String getTrackUrl() {
    return trackUrl;
  }

  public void setTrackUrl(String trackUrl) {
    this.trackUrl = trackUrl;
  }

  public String getTrackListeners() {
    return trackListeners;
  }

  public void setTrackListeners(String trackListeners) {
    this.trackListeners = trackListeners;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public ArtistDTO getArtist() {
    return artist;
  }

  public void setArtist(ArtistDTO artist) {
    this.artist = artist;
  }

  @Override
  public String toString() {
    return "TrackDTO{" +
      "trackId='" + trackId + '\'' +
      ", trackNamne='" + trackNamne + '\'' +
      ", trackUrl='" + trackUrl + '\'' +
      ", trackListeners='" + trackListeners + '\'' +
      ", comments='" + comments + '\'' +
      ", artist=" + artist +
      '}';
  }
}
