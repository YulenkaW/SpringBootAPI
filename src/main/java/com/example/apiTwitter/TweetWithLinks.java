package com.example.apiTwitter;

import java.util.ArrayList;
import java.util.List;

public class TweetWithLinks extends Tweet {
    private List<String> links;

    // Constructor that calls the super() constructor of posts
    public TweetWithLinks(Tweet tweet) {
        super(tweet.getCreated_at(), tweet.getId(), tweet.getText(), tweet.getUser());
        this.links = new ArrayList<>();
    }

    
	// Getters and setters for the 'links' field
    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}