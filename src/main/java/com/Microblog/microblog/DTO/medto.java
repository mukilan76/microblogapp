package com.Microblog.microblog.DTO;

public class medto {
    String name;
    int followerscount;
    int followingcount;
    String bio;
    String username;

    public medto(String name, int followerscount, int followingcount, String bio, String username) {
        this.name = name;
        this.followerscount = followerscount;
        this.followingcount = followingcount;
        this.bio = bio;
        this.username = username;
    }

    public medto(String name, int followerscount, int followingcount, String bio) {
        this.name = name;
        this.followerscount = followerscount;
        this.followingcount = followingcount;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowerscount() {
        return followerscount;
    }

    public void setFollowerscount(int followerscount) {
        this.followerscount = followerscount;
    }

    public int getFollowingcount() {
        return followingcount;
    }

    public void setFollowingcount(int followingcount) {
        this.followingcount = followingcount;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
