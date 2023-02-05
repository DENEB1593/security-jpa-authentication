package io.study.deneb.model;

import java.time.LocalDateTime;

public class PostDto {
    private String title;
    private String slug;
    private String content;
    private String username;
    private LocalDateTime publishedOn;

    public PostDto(String title, String slug, String content, String username, LocalDateTime publishedOn) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.username = username;
        this.publishedOn = publishedOn;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getPublishedOn() {
        return publishedOn;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
