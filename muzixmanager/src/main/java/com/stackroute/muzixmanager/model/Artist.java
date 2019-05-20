package com.stackroute.muzixmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

public class Artist {

  @Id
  private int artistId;
  @JsonProperty("name")
  private String artistNamne;
  @JsonProperty("url")
  private String url;
  private Image image;

  public Artist() {
  }

  public Artist(int artistId, String artistNamne, String url, Image image) {
    this.artistId = artistId;
    this.artistNamne = artistNamne;
    this.url = url;
    this.image = image;
  }

  public int getArtistId() {
    return artistId;
  }

  public void setArtistId(int artistId) {
    this.artistId = artistId;
  }

  public String getArtistNamne() {
    return artistNamne;
  }

  public void setArtistNamne(String artistNamne) {
    this.artistNamne = artistNamne;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "Artist{" +
      "artistId=" + artistId +
      ", artistNamne='" + artistNamne + '\'' +
      ", url='" + url + '\'' +
      ", image=" + image +
      '}';
  }
}
