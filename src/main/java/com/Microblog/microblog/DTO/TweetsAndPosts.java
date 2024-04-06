package com.Microblog.microblog.DTO;



import java.sql.Blob;
import java.time.LocalDateTime;

import static com.Microblog.microblog.utils.TimeAgoConverter.convertToTimeAgo;

public class TweetsAndPosts {
    private int userid;
    private int tweetid;
    private String name;
    private String content;
    private int postid;
    private Blob post;
    private String caption ;
    private LocalDateTime postingTime;
    private String timeago;

    public TweetsAndPosts(int userid, int tweetid, String name, String content, int postid, Blob post, String caption, LocalDateTime postingTime) {
        this.userid = userid;
        this.tweetid = tweetid;
        this.name = name;
        this.content = content;
        this.postid = postid;
        this.post = post;
        this.caption = caption;
        this.postingTime = postingTime;
    }

    public TweetsAndPosts(int userid , String name, int tweetid, String content , LocalDateTime postingTime) {
        this.userid = userid;
        this.name = name;
        this.tweetid = tweetid;
        this.content = content;
        this.postingTime=postingTime;
    }

    public TweetsAndPosts(int userid , String name ,int postid, Blob post, String caption, LocalDateTime postingTime) {
        this.userid=userid;
        this.name=name;
        this.postid = postid;
        this.post = post;
        this.caption = caption;
        this.postingTime = postingTime;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTweetid() {
        return tweetid;
    }

    public void setTweetid(int tweetid) {
        this.tweetid = tweetid;
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

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public Blob getPost() {
        return post;
    }

    public void setPost(Blob post) {
        this.post = post;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(LocalDateTime postingTime) {
        this.postingTime = postingTime;
    }
    public String getTimeago(){
       return  convertToTimeAgo(postingTime);
    }
}
