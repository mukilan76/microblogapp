package com.Microblog.microblog.Entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String username;
    private String name;
    private String email;
    private  String password;
    private String bio;

    public User(int id, String username, String name, String email, String password, String bio) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }

    public User(String username, String name, String email, String password  ) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User(int id, String username, String name, String email, String password) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
