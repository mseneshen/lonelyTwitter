package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by seneshen on 9/12/17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(String message, Date date) throws TweetTooLongException {
        super(message, date);
    }

    @Override
    public Boolean isImportant() {
        return true;
    }
}
