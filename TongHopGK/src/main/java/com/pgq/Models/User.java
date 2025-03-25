package com.pgq.Models;

public class User {
    private String name;
    private String title;
    private String bio;
    private String email;
    private String profileImage;

    // Constructor
    public User(String name, String title, String bio, String email, String profileImage) {
        this.name = name;
        this.title = title;
        this.bio = bio;
        this.email = email;
        this.profileImage = profileImage;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getBio() {
        return bio;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getProfileImage() {
        return profileImage;
    }

}