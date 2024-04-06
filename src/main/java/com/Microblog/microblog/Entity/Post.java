package com.Microblog.microblog.Entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDateTime;

import static com.Microblog.microblog.utils.TimeAgoConverter.convertToTimeAgo;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
    private int userid;
    @Lob
    @Column(name = "post", columnDefinition = "LONGBLOB")
    private Blob post;
    private String caption;
    private LocalDateTime postingTimepost;

    public Post(int id, int userid, Blob post, String caption, LocalDateTime postingTimepost) {
        this.id = id;
        this.userid = userid;
        this.post = post;
        this.caption = caption;
        this.postingTimepost = postingTimepost;
    }

    public Post(int userid, Blob post, String caption, LocalDateTime postingTimepost) {
        this.userid = userid;
        this.post = post;
        this.caption = caption;
        this.postingTimepost = postingTimepost;
    }


    public Post() {

    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public LocalDateTime getPostingTimepost() {
        return postingTimepost;
    }

    public void setPostingTimepost(LocalDateTime postingTimepost) {
        this.postingTimepost = postingTimepost;
    }

    public Blob getPost() {
        return post;
    }

    public void setPost(Blob post) {
        this.post = post;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getTimeago(){
        return  convertToTimeAgo(postingTimepost);
    }
}
