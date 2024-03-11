package com.example.apiTwitter;



public class Tweet {
	
	   private String created_at;
	    private String id; // id_str from JSON as id
	    private String text; // full_text from JSON as text
	    private User user;
	   
	    
	    
	    
	    public Tweet(String created_at, String id, String text, User user) {
	    	this.created_at = created_at;
	        this.id = id;
	        this.text = text;
	        this.user = user;
	        
	    }
	    
	    
	    
	 		// Getter for create_time
	    public String getCreated_at() {
	        return created_at;
	    }

	    // Setter for create_time
	    public void setCreated_at(String created_at) {
	        this.created_at = created_at;
	    }

	    // Getter for id
	    public String getId() {
	        return id;
	    }

	    // Setter for id
	    public void setId(String id) {
	        this.id = id;
	    }

	    // Getter for text
	    public String getText() {
	        return text;
	    }

	    // Setter for text
	    public void setText(String text) {
	        this.text = text;
	    }

	    // Getter for user
	    public User getUser() {
	        return user;
	    }

	    // Setter for user
	    public void setUser(User user) {
	        this.user = user;
	    }

}


