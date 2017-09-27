package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Normal tweet class, used for tweets that are not important.
 *
 * @author Micah Seneshen
 */
public class NormalTweet extends Tweet {

    /**
     * Create a normal tweet with a specific message and date
     *
     * @param message tweet message
     * @param date tweet date
     * @throws TweetTooLongException
     */
    public NormalTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    /**
     * Create a normal tweet with a specific message
     *
     * @param message tweet message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Determine if tweet is important
     *
     * @return important boolean flag
     */
    @Override
    public Boolean isImportant() {
        return false;
    }
}
