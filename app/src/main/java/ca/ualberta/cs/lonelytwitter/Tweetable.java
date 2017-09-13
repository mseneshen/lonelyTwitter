package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by seneshen on 9/12/17.
 */

public interface Tweetable {
    String getMessage();
    void setMessage(String newMessage) throws TweetTooLongException;

    Date getDate();
    void setDate(Date newDate);
}
