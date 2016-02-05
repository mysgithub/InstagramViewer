package com.codepath.instagramviewer.models;

/**
 * Created by Shyam Rokde on 1/30/16.
 */
public class InstagramPhoto {
  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getLikeCount() {
    return likeCount;
  }

  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public int getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(int imageHeight) {
    this.imageHeight = imageHeight;
  }

  public String getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(String profilePicture) {
    this.profilePicture = profilePicture;
  }

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }


  public String getLatestComment() {
    return latestComment;
  }

  public void setLatestComment(String latestComment) {
    this.latestComment = latestComment;
  }

  private String latestComment;
  private String createdTime;
  private String profilePicture;
  private String caption;
  private String username;
  private int likeCount;
  private String imageUrl;
  private int imageHeight;
}
