package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by seneshen on 9/12/17.
 */

public class NormalTweet extends Tweet {

    public NormalTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}
