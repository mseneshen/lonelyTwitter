package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by seneshen on 10/10/17.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    // add tweet to a list of tweets
    public void addTweet(Tweet tweet) throws IllegalArgumentException {
        if(!tweets.contains(tweet)) {
            tweets.add(tweet);
        }else{
            throw new IllegalArgumentException("Attempting to add duplicate tweet.");
        }
    }

    // delete tweet from a list of tweets
    public void deleteTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    // check if a list of tweets has the specified tweet
    // if it does, return true, otherwise return false.
    public boolean hasTweet(Tweet tweet) {

        for(int i=0;i<tweets.size();i++) {
            if(tweets.get(i).equals(tweet)){
                return true;
            }
        }

        return false;
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets() {
        ArrayList<Tweet> chronologicalTweets = new ArrayList<Tweet>();
        chronologicalTweets.addAll(tweets);

        // sort tweets chronologically:
        Collections.sort(chronologicalTweets, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });

        return chronologicalTweets;
    }

    public int getCount() {
        return tweets.size();
    }

}
