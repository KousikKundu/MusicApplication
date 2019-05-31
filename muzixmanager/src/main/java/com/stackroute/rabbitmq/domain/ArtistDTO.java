package com.stackroute.rabbitmq.domain;

import com.stackroute.muzixmanager.model.Image;

public class ArtistDTO {


  private int artistId;
  private String artistNamne;
  private String url;
  private ImageDTO image;

  public ArtistDTO() {
  }

  public ArtistDTO(int artistId, String artistNamne, String url, ImageDTO image) {
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

  public ImageDTO getImage() {
    return image;
  }

  public void setImage(ImageDTO image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "ArtistDTO{" +
      "artistId=" + artistId +
      ", artistNamne='" + artistNamne + '\'' +
      ", url='" + url + '\'' +
      ", image=" + image +
      '}';
  }
}
