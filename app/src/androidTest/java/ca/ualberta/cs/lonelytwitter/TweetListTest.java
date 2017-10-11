package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by seneshen on 10/10/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList tweets = new TweetList();

        Tweet myTweet = new NormalTweet("Message");

        tweets.addTweet(myTweet);

        assertTrue(tweets.hasTweet(myTweet));

        boolean threw = false;

        try {
            tweets.addTweet(myTweet);
        }catch (Exception e){
            threw = true;
        }

        assertTrue(threw);
    }

    public void testDeleteTweet() {
        TweetList tweets = new TweetList();

        Tweet myTweet = new NormalTweet("Message");

        tweets.addTweet(myTweet);
        tweets.deleteTweet(myTweet);

        assertFalse(tweets.hasTweet(myTweet));
    }

    public void testHasTweet() {
        TweetList tweets = new TweetList();

        Tweet myTweet = new NormalTweet("Message");

        assertFalse(tweets.hasTweet(myTweet));

        tweets.addTweet(myTweet);

        assertTrue(tweets.hasTweet(myTweet));

        tweets.deleteTweet(myTweet);

        assertFalse(tweets.hasTweet(myTweet));
    }

    public void testGetTweet() {
        // getTweet method will take an index and will return the tweet at that index
        TweetList tweets = new TweetList();

        ArrayList<Tweet> tweetArrayList = new ArrayList<Tweet>();

        for(int i=0;i<10;i++){
            Tweet tweet = new NormalTweet("Message " + i);
            tweetArrayList.add(tweet);
            tweets.addTweet(tweet);
        }

        for(int i=0;i<10;i++){
            assertEquals(tweetArrayList.get(i),tweets.getTweet(i));
        }

    }

    public void testGetTweets() {
        // getTweets method should return tweets in chronological order

        TweetList tweets = new TweetList();

        ArrayList<Tweet> tweetArrayList = new ArrayList<Tweet>();

        // Build an array of test tweets
        for(int i=0;i<20;i++){
            Tweet tweet = new NormalTweet("Message " + i);
            tweetArrayList.add(tweet);
        }

        // Randomize order of tweets, to make order not chronological
        Collections.shuffle(tweetArrayList);

        // Add tweets to TweetList
        for(int i=0;i<20;i++){
            tweets.addTweet(tweetArrayList.get(i));
        }

        tweetArrayList = tweets.getTweets();

        // Check that tweets are chronological.
        // Get first tweet:
        Tweet previousTweet = tweetArrayList.get(0);

        for(int i=1;i<20;i++){
            Tweet nextTweet = tweetArrayList.get(i);

            // Check that the date of the previous tweet is before or equal to the current tweet:
            assertTrue(previousTweet.getDate().compareTo(nextTweet.getDate()) <= 0);

            // Rotate through for next iteration:
            previousTweet = nextTweet;
        }

    }

    public void testGetCount() {

        int count = 0;

        TweetList tweets = new TweetList();

        assertEquals(tweets.getCount(), count);

        for(int i=0;i<10;i++){
            Tweet tweet = new NormalTweet("Message " + i);
            tweets.addTweet(tweet);
            count++;

            assertEquals(tweets.getCount(), count);

        }


    }

}
