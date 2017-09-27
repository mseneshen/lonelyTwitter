/*
 * Copyright 2017 Team 8, CMPUT 301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior of the University of Alberta.
 * You may find a copy of the licence in this project. Otherwise please contact seneshen@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

import java.util.Date;

/**
 * Represents a tweet.
 *
 * @author Micah Seneshen
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable {

    private String message;
    private Date date;
    private Mood mood;

    /**
     * Constructs a tweet object with a specific message and date.
     *
     * @param message tweet message
     * @param date tweet date
     * @throws TweetTooLongException
     */
    public Tweet(String message, Date date) throws TweetTooLongException{
        this.message = message;
        this.date = date;
    }

    /**
     * Construct a tweet object with a specific message.
     *
     * @param message tweet message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Determine if a tweet is important
     *
     * @return important boolean flag
     */
    public abstract Boolean isImportant();

    /**
     * Get tweet's message
     *
     * @return tweet's message
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Sets tweet message.
     *
     * @param newMessage tweet message
     * @throws TweetTooLongException
     */
    public void setMessage(String newMessage) throws TweetTooLongException {

        if(message.length() > 140){
            throw new TweetTooLongException();
        }

        this.message = newMessage;
    }

    /**
     * Get tweet's mood
     *
     * @return tweet's mood
     */
    public Mood getMood() {
        return mood;
    }

    /**
     * Set tweet's mood
     *
     * @param mood tweet's mood
     */
    public void setMood(Mood mood) {
        this.mood = mood;
    }

    /**
     * Set tweet as happy mood
     */
    public void setHappy(){
        this.mood = new HappyMood();
    }

    /**
     * Set tweet as sad mood
     */
    public void setSad(){
        this.mood = new SadMood();
    }

    /**
     * Get tweet's date
     *
     * @return tweet's date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Set tweet's date
     *
     * @param newDate tweet's date
     */
    public void setDate(Date newDate){
        this.date = newDate;
    }

    /**
     * Get string representation of tweet.
     *
     * @return string formatted tweet
     */
    public String toString(){
        return this.message + " - feeling " + this.mood;
    }

}
