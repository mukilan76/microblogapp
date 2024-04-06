package com.Microblog.microblog.Entity;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userid;
    @Lob
    @Column(name = "profile", columnDefinition = "LONGBLOB")
    private Blob profile;

    public Profile(int id, int userid, Blob profile) {
        this.id = id;
        this.userid = userid;
        this.profile = profile;
    }

    public Profile(int userid, Blob profile) {
        this.userid = userid;
        this.profile = profile;
    }

    public Profile() {

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

    public Blob getProfile() {
        return profile;
    }

    public void setProfile(Blob profile) {
        this.profile = profile;
    }
}
