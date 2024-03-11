package com.example.apiTwitter;

//import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIService {

	private final RestTemplate restTemplate;
    private List<Tweet> tweets;

 // Since Spring 4.3, @Autowired annotation is not required for single constructor
    public APIService(RestTemplate restTemplate) { 
        this.restTemplate = restTemplate; 
        String jsonUrl = "https://foyzulhassan.github.io/files/favs.json";
        
        // Use the class field restTemplate to fetch and populate posts
        Tweet[] tweetArray = this.restTemplate.getForObject(jsonUrl, Tweet[].class);
        tweets = Arrays.asList(tweetArray != null ? tweetArray : new Tweet[0]);
    }

    public List<Tweet> getAllTweets() {
        return tweets;
    }

    
    public Tweet getTweetDetails(String tweetId) {
        return getAllTweets().stream()
                .filter(tweet -> tweet.getId().equals(tweetId))
                .findFirst()
                .orElse(null);
    }
    
    
    public User getUserDetails(String screenName) {
        return getAllTweets().stream()
                .map(Tweet::getUser)
                .filter(user -> user.getName().equals(screenName))
                .findFirst()
                .orElse(null);
    }
    
    
    
    
    public Map<String, List<String>> extractLinks() {
        List<Tweet> tweets = getAllTweets();
        Map<String, List<String>> linksByTweetId = new HashMap<>();

        for (Tweet tweet : tweets) {
            List<String> links = new ArrayList<>();
            String[] words = tweet.getText().split("\\s+");
            for (String word : words) {
                if (word.startsWith("http://") || word.startsWith("https://")) {
                    links.add(word);
                }
            }
            linksByTweetId.put(tweet.getId(), links);
        }
        return linksByTweetId;
    }
    
    
    public List<TweetWithLinks> getAllTweetsWithLinks() {
    	List<Tweet> baseTweets = getAllTweets();

        
        return baseTweets.stream()
        		   .map(tweet -> {
                       TweetWithLinks tweetWithLinks = new TweetWithLinks(tweet);
                       List<String> links = extractLinksForTweet(tweet); 
                       tweetWithLinks.setLinks(links); 
                       return tweetWithLinks;
                   })
                   .collect(Collectors.toList());
    }
    
    
    private List<String> extractLinksForTweet(Tweet tweet) {
        String regex = "https?://\\S+\\b";
        List<String> links = new ArrayList<>();
        String[] parts = tweet.getText().split("\\s+");
        for (String part : parts) {
            if (part.matches(regex)) {
                links.add(part);
            }
        }
        return links;
    }
    
    
}