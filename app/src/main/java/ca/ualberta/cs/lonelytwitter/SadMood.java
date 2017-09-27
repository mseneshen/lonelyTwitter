package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Sad mood class
 *
 * @author Micah Seneshen
 */
public class SadMood extends Mood {

    /**
     * Create a sad mood object
     */
    public SadMood() {
        super();
        this.mood = "Sad";
    }

    /**
     * Create a sad mood object with a specific date
     *
     * @param date
     */
    public SadMood(Date date) {
        super(date);
        this.mood = "Sad";
    }
}
