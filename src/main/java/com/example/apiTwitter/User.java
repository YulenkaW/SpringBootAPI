package com.example.apiTwitter;


public class User {
	 private String screen_name;
	    private String name;
	    private String description;
	    private int followers_count;
	    private int friends_count;
	    private int favourites_count; // provided JSON
	    
	    public String getScreen_name() {
	        return screen_name;
	    }

	    // Setter for screen_name
	    public void setScreen_name(String screen_name) {
	        this.screen_name = screen_name;
	    }

	    // Getter for name
	    public String getName() {
	        return name;
	    }

	    // Setter for name
	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter for description
	    public String getDescription() {
	        return description;
	    }

	    // Setter for description
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    // Getter for followers_count
	    public int getFollowers_count() {
	        return followers_count;
	    }

	    // Setter for followers_count
	    public void setFollowers_count(int followers_count) {
	        this.followers_count = followers_count;
	    }

	    // Getter for friends_count
	    public int getFriends_count() {
	        return friends_count;
	    }

	    // Setter for friends_count
	    public void setFriends_count(int friends_count) {
	        this.friends_count = friends_count;
	    }

	    // Getter for favourites_count
	    public int getFavourites_count() {
	        return favourites_count;
	    }

	    // Setter for favourites_count
	    public void setFavourites_count(int favourites_count) {
	        this.favourites_count = favourites_count;
	    }
	}
	    


