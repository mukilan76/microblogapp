package com.Microblog.microblog.DTO;

import com.Microblog.microblog.Entity.Tweet;

import java.util.List;

public class alluserDTO {
private int id;
    private  String name ;

    private boolean followed;
    private String profile;

    public alluserDTO(int id, String name, boolean followed , String profile) {
        this.id = id;
        this.name = name;
        this.followed = followed;
        this.profile=profile;
    }

    public alluserDTO(int id, String name, boolean followed) {
        this.id = id;
        this.name = name;
        this.followed = followed;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}
