package com.Microblog.microblog.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FollowersFollowing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int following ;
    int followers;

    public FollowersFollowing(int following, int followers) {
        this.following = following;
        this.followers = followers;
    }

    public FollowersFollowing(int id, int following, int followers) {
        this.id = id;
        this.following = following;
        this.followers = followers;
    }

    public FollowersFollowing() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
