package com.Microblog.microblog.DTO;

import java.time.LocalDateTime;

public class TweetsDTO {
   private String name;
   private String content;
    private LocalDateTime postingTimetweet;

    public TweetsDTO(String name, String content, LocalDateTime postingTimetweet) {
        this.name = name;
        this.content = content;
        this.postingTimetweet = postingTimetweet;
    }

    public TweetsDTO(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime  getPostingTimetweet() {
        return postingTimetweet;
    }

    public void setPostingTimetweet(LocalDateTime postingTimetweet) {
        this.postingTimetweet = postingTimetweet;
    }
}
