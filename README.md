# SpringBootAPI
 get retrieved data from Twitter


Companies like Twitter have strong RESTful APIs that allows users to explore the wealth of data they manage and even provide ways to download your entire archive of tweets. Many users rely on Twitter’s favorites as a mechanism to bookmark tweets that link to interesting content elsewhere on the web. However, in order to avoid a potential downfall in the future, where those favorites could one day become unavailable, you've decided to retrieve a list with your favorite tweets as a JSON object. Find the sample JSON file at the following link:

https://foyzulhassan.github.io/files/favs.json

Specification

Your RESTful APIs should be able to respond, with the appropriate data, to the following requests:

Get all tweets (create time, id, and tweet text) available in the archive.
Get a list of all external links (all links that appear in tweet text field. Use regular expressions to extract the links , the links should be grouped based on tweet ids.
Get the details (tweet created_at, text, user screen_name) about a given tweet (given the tweet’s id).
Get detailed profile (location, description, followers_count, friends_count) information about a given Twitter user (given the user’s screen name).
 
 
Here is an example testing API in Postman
I![image](https://github.com/YulenkaW/SpringBootAPI/assets/83892913/48ccd77d-b390-4839-868c-c243d1599e79)

To compile it:
I would strongly recommend to instal Maven or Gradle: 
Navigate to the project directory and run one of the following commands:
Maven:
shell:
mvn clean package

Gradle:
shell
./gradlew build
This will create an executable JAR file in the target (Maven) or build/libs (Gradle) directory.

On the Windows laptop: Open a shell (Command Prompt or PowerShell), navigate to the directory containing the JAR file, and run:

shell:
java -jar APITwitter.jar
Make sure Java is installed on the laptop. You can check by running java -version. If Java is not installed, you will need to install it.



