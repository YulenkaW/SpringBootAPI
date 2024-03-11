package com.example.apiTwitter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api")
public class APITwitterController {

    @Autowired
    private APIService apiService;

    @GetMapping("/tweets")
    public ResponseEntity<List<Map<String, Object>>> getTweets() {
        List<Map<String, Object>> tweetDetails = apiService.getAllTweetsWithLinks().stream().map(tweetWithLinks -> {
            Map<String, Object> tweetInfo = new HashMap<>();
            tweetInfo.put("created_at", tweetWithLinks.getCreated_at());
            tweetInfo.put("id", tweetWithLinks.getId());
            tweetInfo.put("text", tweetWithLinks.getText());
            tweetInfo.put("links", tweetWithLinks.getLinks());
            return tweetInfo;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(tweetDetails);
    }
    
    
    
    @GetMapping("/tweets/{tweet_id}")
    public ResponseEntity<?> getTweet(@PathVariable("tweet_id") String tweetId) {
        Tweet tweet = apiService.getTweetDetails(tweetId);
        if (tweet != null) {
            return ResponseEntity.ok(tweet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/{screen_name}")
    public ResponseEntity<?> getUser(@PathVariable("screen_name") String screenName) {
        User user = apiService.getUserDetails(screenName);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
 // get links by  ID
    @GetMapping("/links")
    public ResponseEntity<Map<String, List<String>>> getLinks() {
        Map<String, List<String>> links = apiService.extractLinks();
        return ResponseEntity.ok(links);
    }
    
}	
