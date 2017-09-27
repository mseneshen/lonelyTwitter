package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Interface for objects that are tweetable
 *
 * @author Micah Seneshen
 */
public interface Tweetable {

    /**
     * Get tweetable's message
     *
     * @return message
     */
    String getMessage();

    /**
     * Sets tweetable's message
     *
     * @param newMessage
     * @throws TweetTooLongException
     */
    void setMessage(String newMessage) throws TweetTooLongException;

    /**
     * Get tweetable's date
     *
     * @return date
     */
    Date getDate();

    /**
     * Set tweetable's date
     *
     * @param newDate
     */
    void setDate(Date newDate);
}
