package com.stackroute.muzixmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Track {

  @Id
  private String trackId;
  @JsonProperty("name")
  private String trackNamne;
  @JsonProperty("url")
  private String trackUrl;
  @JsonProperty("listeners")
  private String trackListeners;
  private String comments;

  private Artist artist;

  public Track() {
  }

  public Track(String trackId, String trackNamne, String trackUrl, String trackListeners, String comments, Artist artist) {
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

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  @Override
  public String toString() {
    return "Track{" +
      "trackId=" + trackId +
      ", trackNamne=" + trackNamne +
      ", trackUrl=" + trackUrl +
      ", trackListeners=" + trackListeners +
      ", comments=" + comments +
      ", artist=" + artist +
      '}';
  }
}
