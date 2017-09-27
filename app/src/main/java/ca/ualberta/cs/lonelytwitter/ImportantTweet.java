package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Important tweet class
 * @author Micah Seneshen
 */
public class ImportantTweet extends Tweet {
    /**
     * Create new important tweet object with specific message
     *
     * @param message tweet's message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Create new important tweet object with specific message and date
     *
     * @param message
     * @param date
     * @throws TweetTooLongException
     */
    public ImportantTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    /**
     * Determine if tweet is important
     *
     * @return important boolean flag
     */
    @Override
    public Boolean isImportant() {
        return true;
    }
}
