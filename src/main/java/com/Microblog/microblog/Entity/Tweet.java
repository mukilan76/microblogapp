package com.Microblog.microblog.Entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDateTime;

import static com.Microblog.microblog.utils.TimeAgoConverter.convertToTimeAgo;

@Entity
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userid;
   private  String content;
    private LocalDateTime postingTimetweet;


    public Tweet(int userid, String content , LocalDateTime postingTimetweet) {
        this.userid = userid;
        this.content = content;
        this.postingTimetweet=postingTimetweet;
    }

    public Tweet(int id , int userid, String content ,LocalDateTime postingTimetweet) {
        this.id=id;
        this.userid = userid;
        this.content = content;
        this.postingTimetweet= postingTimetweet;
    }

    public LocalDateTime getPostingTimetweet() {
        return postingTimetweet;
    }

    public void setPostingTimetweet(LocalDateTime postingTimetweet) {
        this.postingTimetweet = postingTimetweet;
    }

    public Tweet() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getTimeago(){
        return  convertToTimeAgo(postingTimetweet);
    }
}
