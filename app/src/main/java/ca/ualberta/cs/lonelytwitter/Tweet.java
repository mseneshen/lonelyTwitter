package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

import java.util.Date;

/**
 * Created by seneshen on 9/12/17.
 */

public abstract class Tweet implements Tweetable {

    private String message;
    private Date date;
    private Mood mood;

    public Tweet(String message, Date date) throws TweetTooLongException{
        this.message = message;
        this.date = date;
    }

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String newMessage) throws TweetTooLongException {

        if(message.length() > 140){
            throw new TweetTooLongException();
        }

        this.message = newMessage;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public void setHappy(){
        this.mood = new HappyMood();
    }

    public void setSad(){
        this.mood = new SadMood();
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date newDate){
        this.date = newDate;
    }

    public String toString(){
        return this.message + " - feeling " + this.mood;
    }

}
