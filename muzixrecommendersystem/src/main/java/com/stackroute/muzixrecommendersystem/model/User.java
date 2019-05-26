package com.stackroute.muzixrecommendersystem.model;



import java.util.List;


public class User {

  private String userName;
  private String email;
  private List<Track> trackList;
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User() {
  }

  public User(String userName, String email, List<Track> trackList) {
    this.userName = userName;
    this.email = email;
    this.trackList = trackList;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Track> getTrackList() {
    return trackList;
  }

  public void setTrackList(List<Track> trackList) {
    this.trackList = trackList;
  }

  @Override
  public String toString() {
    return "User{" +
            "userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            ", trackList=" + trackList +
            '}';
  }
}
