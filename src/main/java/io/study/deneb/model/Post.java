package io.study.deneb.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String title;
  private String slug;
  private String content;

  private String username;
  private LocalDateTime publishedOn;
  private LocalDateTime updatedOn;

  public Post() {}

  public Post(String title, String slug, String content, String username ) {
    this.title = title;
    this.slug = slug;
    this.content = content;
    this.username = username;
    this.publishedOn = LocalDateTime.now();
    this.updatedOn = LocalDateTime.now();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public LocalDateTime getPublishedOn() {
    return publishedOn;
  }

  public void setPublishedOn(LocalDateTime publishedOn) {
    this.publishedOn = publishedOn;
  }

  public LocalDateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(LocalDateTime updatedOn) {
    this.updatedOn = updatedOn;
  }

  @Override
  public String toString() {
    return "Post{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", slug='" + slug + '\'' +
      ", content='" + content + '\'' +
      ", username='" + username + '\'' +
      ", publishedOn=" + publishedOn +
      ", updatedOn=" + updatedOn +
      '}';
  }

}